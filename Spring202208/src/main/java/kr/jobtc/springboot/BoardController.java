package kr.jobtc.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.jobtc.springboot.board.BoardService;
import kr.jobtc.springboot.board.BoardVo;

@RestController
public class BoardController {
		
	JdbcTemplate jdbcTemp;	//mybatis를 사용하게 되면 불필요
	
	@Autowired
	BoardService service;
	
	public BoardController(JdbcTemplate temp) {
		this.jdbcTemp = temp;
	}
	
	@RequestMapping("/board/board_select")
	public ModelAndView select() {
		ModelAndView mv = new ModelAndView();
		List<BoardVo>list = service.select("1");
		
		mv.addObject("list", list); 	
		//mvc 중 m(model)
		mv.setViewName("board/board_select");	//WEB-INF/view/board/board_select.jsp
		return mv;
	}
	
//	@RequestMapping("/board/test")	
//	public ModelAndView test() {
//		ModelAndView mv = new ModelAndView();
//		List<String> subjects = null;
//		try {
//			Connection conn = jdbcTemp.getDataSource().getConnection();
//			String sql = "select subject from board";
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			subjects = new ArrayList<String>();
//			while(rs.next()) {
//				subjects.add(rs.getString("subject"));
//			}
//			rs.close();
//			ps.close();
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		mv.addObject("subjects", subjects); 	//mvc 중 m(model)
//		mv.setViewName("board/board_select");	//WEB-INF/view/board/board_select.jsp
//		// WEB-INF에 있는 파일은 외부에서 접근이 불가능하다. 컨트롤러를 통해서 실행해야함
//		return mv;
//	}
}
