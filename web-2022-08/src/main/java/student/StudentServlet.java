package student;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/student.do")   //그냥 메인에서 시작되도록 경로 수정했다.
public class StudentServlet extends HttpServlet{
   String path = "index.jsp?inc=student/";
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("나야나");
      Page pageVo = new Page();
      
      StudentDao dao = new StudentDao();
      List<StudentVo> list = dao.select(pageVo);
      
      String url = path + "(강사님ver)student_list.jsp";
      RequestDispatcher rd = req.getRequestDispatcher(url);
      req.setAttribute("list", list);
      req.setAttribute("pageVo", pageVo);
      
      rd.forward(req, resp);
      
      
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
   }
   
   
   
}