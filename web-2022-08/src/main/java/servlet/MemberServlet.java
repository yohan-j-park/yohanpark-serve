package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.MemberDao;

@WebServlet(urlPatterns = "/memberServlet.do")
public class MemberServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String job = req.getParameter("job");
       if(job==null) job="";
       switch(job) {
           case "":
               select(req, resp);
               break;
           case "view":
               view(req, resp);
               break;
           case "delete":
               delete(req, resp);
               break;
       }

    }
       
    protected void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        MemberDao dao = new MemberDao();
        JSONObject obj = dao.view(id);
        PrintWriter out = resp.getWriter();
        out.print(obj.toJSONString()); 
    }
    
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String delFile = req.getParameter("delFile");
        MemberDao dao = new MemberDao();
        String msg = dao.delete(id,delFile);
        PrintWriter out = resp.getWriter();
        out.print(msg);
        
        
    }
    
    protected void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String findStr = req.getParameter("findStr");
        MemberDao dao = new MemberDao();
        JSONArray array = dao.select(findStr);
        
        PrintWriter out = resp.getWriter();
        out.print(array.toJSONString());    
    }
    

}
       
    
