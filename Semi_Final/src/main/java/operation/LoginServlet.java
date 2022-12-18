package operation;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jdbc.Login;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	String path = "index.jsp?inc=";
	Login l;
	String url = "";
	RequestDispatcher rd = null;
	
	public LoginServlet() {
		l = new Login();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(l == null) l = new Login();
		String job = req.getParameter("job");
		switch(job) {
		case "login":
			login(req, resp);
		case "logout":
			logout(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String job = req.getParameter("job");
		HttpSession session = req.getSession();   

		switch(job) {
		case "login":
			String mId = req.getParameter("mId");
			String pwd = req.getParameter("pwd"); 

			Login l = new Login();
			String b = l.login(mId, pwd);

			if(b!=null){
				url = path + "temp.html";
			    session.setAttribute("sessionId", mId);
			    session.setAttribute("sessionPwd", pwd);
     			session.setAttribute("Access_level", b);
     			rd = req.getRequestDispatcher(url);
     			rd.forward(req, resp);
     			
			   
			}else{
				url = path + "member/login.jsp";
				rd = req.getRequestDispatcher(url);
				rd.forward(req, resp);
			}
		}
	}
	
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		url = path + "member/login.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();  
		url = path + "temp.html";
		session.setAttribute("sessionId", null);
		session.setAttribute("Access_level", null);
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
		
	}
}
