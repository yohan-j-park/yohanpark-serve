package score;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mybatisScore/scoreServlet.do")
public class ScoreServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScorePageVo pVo = new ScorePageVo();
        req.setAttribute("pVo", pVo);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String job = req.getParameter("job");
       if(job==null) job="";
       switch(job) {
           case "":     
           case "select":
               select(req, resp);
               break;
           case "view":
               view(req, resp);
               break;
           case "delete":
               delete(req, resp);
               break;
           case "insert":
               insert(req, resp);
               break;
           case "update":
               update(req, resp);
               break;
           case "insertR":
               insertR(req,resp);
               break;
           case "updateR":
               updateR(req,resp);
               break;
           }
       }
       
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ScoreDao dao = new ScoreDao();
        ScoreVo bVo = dao.view(id);
        req.setAttribute("bVo", bVo);
        RequestDispatcher rd = req.getRequestDispatcher("score_update.jsp");
        rd.include(req, resp);
    }

    
    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("score_insert.jsp");
        rd.include(req, resp);
    }
       
    protected void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ScoreDao dao = new ScoreDao();
        ScoreVo bVo = dao.view(id);
        req.setAttribute("bVo", bVo);
        RequestDispatcher rd = req.getRequestDispatcher("score_view.jsp");
        rd.include(req, resp);
        
    }
    
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String delFile = req.getParameter("delFile");
        ScoreDao dao = new ScoreDao();
        ScorePageVo pVo = (ScorePageVo)req.getAttribute("pVo");
        String msg = dao.delete(id);
        
        
        List<ScoreVo> list = dao.select(pVo);
        
        req.setAttribute("pVo", pVo);
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("score_select.jsp");
        rd.include(req, resp); 
    }
    
    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScorePageVo pVo = (ScorePageVo)req.getAttribute("pVo");
        ScoreDao dao = new ScoreDao();
        List<ScoreVo> list = dao.select(pVo);
        pVo = dao.getpVo();     // 조회 후 page갱신

        
        req.setAttribute("pVo",pVo);
        req.setAttribute("list",list);
        RequestDispatcher rd = req.getRequestDispatcher("score_select.jsp");
        rd.include(req, resp);
        
    }
    
    private void insertR(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        ScoreVo vo = new ScoreVo();
        ScorePageVo pVo = new ScorePageVo(); 
        
        vo.setId(req.getParameter("id"));
        vo.setMdate(req.getParameter("mdate"));
        vo.setSubject(req.getParameter("subject"));
        vo.setScore(Integer.parseInt(req.getParameter("score")));
            
        pVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
        pVo.setFindStr(req.getParameter("findStr"));
            
        ScoreDao dao = new ScoreDao();  // dao 객체를 생성하는 순간 dao의 생성자에 있는 opensession이 실행됨
        String msg=dao.insert(vo);
        System.out.println("insert msg : " + msg);
        List<ScoreVo> list = dao.select(pVo);
        
        req.setAttribute("msg", msg);
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("score_select.jsp");
        rd.include(req, resp);
    }
    private void updateR(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        System.out.println("updateR연결");
        ScoreVo vo = new ScoreVo();
        ScorePageVo pVo = new ScorePageVo(); 
        
        vo.setId(req.getParameter("id"));
        vo.setMdate(req.getParameter("mdate"));
        vo.setSubject(req.getParameter("subject"));
        vo.setScore(Integer.parseInt(req.getParameter("score")));
            
        pVo.setNowPage(Integer.parseInt(req.getParameter("nowPage")));
        pVo.setFindStr(req.getParameter("findStr"));
            
        ScoreDao dao = new ScoreDao();  // dao 객체를 생성하는 순간 dao의 생성자에 있는 opensession이 실행됨
        String msg=dao.update(vo);
        
        if(!msg.equals("")) {
            PrintWriter out = resp.getWriter();
            out.print("<script>");
            out.print("alert('"+msg+"')");
            out.print("</script>");
        }
        System.out.println("update msg : " + msg);
        List<ScoreVo> list = dao.select(pVo);
        
        req.setAttribute("msg", msg);
        req.setAttribute("list", list);
        RequestDispatcher rd = req.getRequestDispatcher("score_select.jsp");
        rd.include(req, resp);
    }

}
       
    
