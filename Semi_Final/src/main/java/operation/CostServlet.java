package operation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cost.do")
public class CostServlet extends HttpServlet{
	String path = "index.jsp?inc=operation/";
	CostDao dao;
	
	public CostServlet() {
		dao = new CostDao();
		System.out.println("Cost servlet created...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao==null) dao = new CostDao();
		select(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao==null) dao = new CostDao();
		String job = req.getParameter("job");
		System.out.println("job : " + job);
		
		switch(job) {
		case "select":
			select(req,resp);
			break;
		case "update":
			update(req,resp);
			break;
		case "updateR":
			updateR(req,resp);
			break;
		}
	}

	public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(dao==null) dao = new CostDao();
		List<CostVo> list = dao.select();
		dao.close();
		
		String url = path + "cost_list.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		req.setAttribute("list", list);
		rd.forward(req, resp);
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(dao == null) dao = new CostDao();
		String url = path + "cost_modify.jsp";
		String pr_name = req.getParameter("pr_name");
		CostVo vo = dao.view(pr_name);
		
		RequestDispatcher rd = req.getRequestDispatcher(url);
		req.setAttribute("vo", vo);
		
		rd.forward(req, resp);
	}
	
	public void updateR(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(dao == null) dao = new CostDao();
		CostVo vo = (CostVo)req.getAttribute("vo");
		boolean b = dao.modify(vo);
		if(b) {
			select(req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.print("<script>");
			out.print("     alert('자료에 오류가 발생!!!');");
			out.print("     history.back();");	//입력폼으로 다시 이동
			out.print("</script>");
		}
	}
	
}
