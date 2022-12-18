package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import member.MemberDao;
import member.MemberVo;
import member.MybatisMemberDao;
import member.MybatisPageVo;

@MultipartConfig(
  location = "c:/temp",
  maxFileSize = -1,
  maxRequestSize = -1,
  fileSizeThreshold = 4096
)
@WebServlet(urlPatterns = "/mybatis/mmfs.do")
public class MybatisMemberFileUploadServlet extends HttpServlet{
   public static String path = 
           "C:\\Users\\p_yoh\\eclipse-workspace\\web-2022-08\\src\\main\\webapp\\upload\\";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String job = req.getParameter("job");
        switch(job) {
            case "insert":
                insert(req,resp);
                break;
            case "update":
                update(req,resp);
                break; 
        }
    }
    private void insert(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        MemberVo vo = new MemberVo();
        MybatisPageVo pVo = new MybatisPageVo(); 
        Collection<Part> parts = req.getParts(); 
        for(Part p : parts) {
            if(p.getHeader("Content-Disposition").contains("filename=")) {    
                if(p.getSize()>0) {
                    
                    String sysFile = new Date().getTime() + "-" + p.getSubmittedFileName();
                    String oriFile = p.getSubmittedFileName();
                    vo.setSysFile(sysFile);
                    vo.setOriFile(oriFile);
                    
                    p.write(path + sysFile);
                    p.delete();
                }
            }
        }   
            
        vo.setId(req.getParameter("id"));
        vo.setName(req.getParameter("name"));
        vo.setPhone(req.getParameter("phone"));
        vo.setGender(req.getParameter("gender"));
        vo.setMdate(req.getParameter("mdate"));
            
        pVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
        pVo.setFindStr(req.getParameter("findStr"));
            
        MybatisMemberDao dao = new MybatisMemberDao();  // dao 객체를 생성하는 순간 dao의 생성자에 있는 opensession이 실행됨
        String msg=dao.insert(vo);
        System.out.println("insert msg : " + msg);
        List<MemberVo> list = dao.select(pVo);
        
        req.setAttribute("msg", msg);
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("member_select.jsp");
        rd.include(req, resp);
    }
    private void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        MemberVo vo = new MemberVo();
        MybatisPageVo pVo = new MybatisPageVo(); 
        Collection<Part> parts = req.getParts(); 
        for(Part p : parts) {
            
            if(p.getHeader("Content-Disposition").contains("filename=")) {    
                if(p.getSize()>0) {
                    
                    String sysFile = new Date().getTime() + "-" + p.getSubmittedFileName();
                    String oriFile = p.getSubmittedFileName();
                    vo.setSysFile(sysFile);
                    vo.setOriFile(oriFile);
                    
                    p.write(path + sysFile);
                    p.delete();
                    
                    // 기존 프로필 사진 파일을 삭제
                    String delFile = req.getParameter("delFile");
                    File file = new File(path+delFile);
                    if(file.exists()) file.delete();
                    
                }
            }
        }         
        vo.setId(req.getParameter("id"));
        vo.setName(req.getParameter("name"));
        vo.setPhone(req.getParameter("phone"));
        vo.setGender(req.getParameter("gender"));
        vo.setMdate(req.getParameter("mdate"));
            
        pVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
        pVo.setFindStr(req.getParameter("findStr"));
            
        MybatisMemberDao dao = new MybatisMemberDao();  // dao 객체를 생성하는 순간 dao의 생성자에 있는 opensession이 실행됨
        String msg=dao.update(vo);
        
        if(!msg.equals("")) {
            PrintWriter out = resp.getWriter();
            out.print("<script>");
            out.print("alert('"+msg+"')");
            out.print("</script>");
        }
        System.out.println("update msg : " + msg);
        List<MemberVo> list = dao.select(pVo);
        
        req.setAttribute("msg", msg);
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("member_select.jsp");
        rd.include(req, resp);
    }
    
}
