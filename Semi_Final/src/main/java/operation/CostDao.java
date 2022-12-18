package operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.DBConn;

public class CostDao {

	Connection conn;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public CostDao() {
		conn = new DBConn("operation_management").getConn();
	}
	
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
			rs=null;
			ps=null;
			conn=null;					
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public List<CostVo> select(){		
		if(conn==null) conn = new DBConn("operation_management").getConn();
		List<CostVo> list = new ArrayList<CostVo>();
		String sql = "";
		
		sql = " select * from robot_cost ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CostVo vo = new CostVo();
				vo.setPr_name(rs.getString("pr_name"));
				vo.setRobot_cost(rs.getString("robot_cost"));
				vo.setProfit_rate(rs.getString("profit_rate"));
				list.add(vo);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public CostVo view(String pr_code) {
		if(conn==null) conn = new DBConn("operation_management").getConn();
		CostVo vo = new CostVo();
		String sql = "select * from robot_cost where pr_name = ?";
		
		try {
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, pr_code);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			vo.setPr_name(rs.getString("pr_name"));
			vo.setRobot_cost(rs.getString("robot_cost"));
			vo.setProfit_rate(rs.getString("profit_rate"));		
		}
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		close();
		return vo;
	}
	
	public boolean modify(CostVo vo) {
		if(conn == null) conn = new DBConn("operation_management").getConn();
		boolean b = false; 
		String sql = " update robot_cost set "
				   + " robot_cost = ? , "
				   + " profit_rate = ? "
		           + " where pr_name = ? ";
				
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getRobot_cost());
			ps.setString(2, vo.getProfit_rate());
			ps.setString(3, vo.getPr_name());
		
			int cnt = ps.executeUpdate();
			System.out.println(cnt);
			if(cnt>0) {
				b = true;
				conn.commit();
			}else {
				conn.rollback();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return b;
	}
	
}
