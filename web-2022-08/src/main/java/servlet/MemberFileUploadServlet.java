package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;

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

@MultipartConfig(
  location = "c:/temp",
  maxFileSize = -1,
  maxRequestSize = -1,
  fileSizeThreshold = 4096
)
@WebServlet(urlPatterns = "/memberUpload.do")
public class MemberFileUploadServlet extends HttpServlet{
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
            }else {
                String tag = p.getName();
                String value = req.getParameter(tag);
                req.setAttribute(tag, value);
                switch(tag) {
                    case "id":
                        vo.setId(value);
                        break;
                    case "name":
                        vo.setName(value);
                        break;
                    case "phone":
                        vo.setPhone(value);
                        break;
                    case "gender":
                        vo.setGender(value);
                        break;
                }
                        
            }
        }   
        MemberDao dao = new MemberDao();
        String msg=dao.insert(vo);
        req.setAttribute("msg", msg);
        RequestDispatcher rd = req.getRequestDispatcher("member/member_insert_result.jsp");
        rd.forward(req, resp);
    }
    private void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        MemberVo vo = new MemberVo();
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
            }else {
                String tag = p.getName();
                String value = req.getParameter(tag);
                req.setAttribute(tag, value);
                switch(tag) {
                    case "id":
                        vo.setId(value);
                        break;
                    case "name":
                        vo.setName(value);
                        break;
                    case "phone":
                        vo.setPhone(value);
                        break;
                    case "gender":
                        vo.setGender(value);
                        break;
                    case "delFile":
                        vo.setDelFile(value);
                }
                        
            }
        }   
        MemberDao dao = new MemberDao();
        String msg = dao.update(vo);
        
        PrintWriter out = resp.getWriter();
        out.print(msg);
        
    }
    
}
