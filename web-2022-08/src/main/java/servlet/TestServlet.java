package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/sbs.kr","/servlet/mbc.kr"}) 
public class TestServlet extends HttpServlet{   
    // protected는 상속을 받아서 사용 가능하다. TestServlet은 접근권한이 protected보다 같거나 넓은것만 가능하다

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // request.getParameter("id")할 때 request의 풀네임이 HttpServletRequest
        // response.Redirect할 때 response의 풀네임이 HttpServletResponse
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
       resp.setContentType("text/html;charset=UTF-8");

       String id = req.getParameter("id");
       String phone = req.getParameter("phone");
//     PrintWriter pw = resp.getWriter();
       

       System.out.println("get으로 호출됨");
       System.out.println("id : " + id);
       System.out.println("phone : " + phone);
       
       // 결과 전송
       RequestDispatcher rd = req.getRequestDispatcher("test_servlet.jsp");
       rd.forward(req, resp);   // client에게 결과를 표시해줄 페이지를 다시 보냄
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        String id = req.getParameter("id");
        String phone = req.getParameter("phone");
        
//      PrintWriter pw = resp.getWriter();
        System.out.println("post로 호출됨");
        System.out.println("id : " + id);
        System.out.println("phone : " + phone);
        
        // 결과 전송
        RequestDispatcher rd = req.getRequestDispatcher("test_servlet.jsp");
//      RequestDispatcher rd = req.getRequestDispatcher("../index.jsp");
//      index.jsp파일로 이동하지만 url은 index.jsp로 바뀌지 않는다  
        rd.include(req, resp);

    }
    
}
