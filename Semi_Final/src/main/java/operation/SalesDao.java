package operation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jdbc.DBConn;

public class SalesDao{
	Connection conn;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public SalesDao() {
		try {
			conn = new DBConn("operation_management").getConn();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void close() {		// rs, ps, conn
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
		
	public boolean insert(OperationVo vo) {
		if(conn == null) conn = new DBConn("operation_management").getConn();
		
		boolean b = false;
		String sql = " insert into om(date, "
						+ " machine_no, manager, pr_code, pr_name, "
						+ " taken_time, pf, status, update_time, pr_cost, real_price, vat, supply_price) "
						+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getDate());
			ps.setString(2, vo.getMachine_no());
			ps.setString(3, vo.getManager());
			ps.setString(4, vo.getPr_code());
			ps.setString(5, vo.getPr_name());
			ps.setString(6, vo.getTaken_time());
			ps.setString(7, vo.getPf());
			ps.setString(8, vo.getStatus());
			ps.setString(9, vo.getUpdate_time());
			ps.setString(10, vo.getPr_cost());
			ps.setString(11, vo.getReal_price());
			ps.setString(12, vo.getVat());
			ps.setString(13, vo.getSupply_price());
			
			int cnt = ps.executeUpdate();
			if(cnt>0) {
				conn.commit();
				b=true;
			}else {
				conn.rollback();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		return b;
	}
	
	
	
	
	public List<CostVo> select_cost(){
		if(conn == null) conn = new DBConn("operation_management").getConn();
		List<CostVo> list_cost = new ArrayList<CostVo>();
		String sql = " select * from robot_cost ";
		try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			CostVo vo_cost = new CostVo();
			vo_cost.setPr_name(rs.getString("pr_name"));
			vo_cost.setRobot_cost(rs.getString("robot_cost"));
			vo_cost.setProfit_rate(rs.getString("profit_rate"));
			list_cost.add(vo_cost);	
		}
		
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list_cost;
	}
	
	public List<OperationVo> select(Page pageVo){
		if(conn == null) conn = new DBConn("operation_management").getConn();
		List<OperationVo> list = new ArrayList<OperationVo>();
		String sql = "";
		//검색된 전체 건수
		try {
			sql = " select count(pr_code) totSize from om "	//select에서의 검색 조건과 같아야 한다.
					+ " where  pr_code like ? "
					+ " and    date like ? "
					+ " and    update_time like ? "
					+ " and    pr_name like ? "
					+ " and    status like ? ";
					
			
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + pageVo.getFindPrcode() + "%");
			ps.setString(2, "%" + pageVo.getFindDate() + "%");
			ps.setString(3, "%" + pageVo.getFindUpdate_time() + "%");
			ps.setString(4, "%" + pageVo.getFindPrname() + "%");
			ps.setString(5, "%" + pageVo.getFindStatus() + "%");
			
			
			
			rs = ps.executeQuery();
			rs.next();
			int totSize = rs.getInt("totSize");
			pageVo.setTotSize(totSize);
			pageVo.compute();
			
			sql = " select * from om "
					+ " where  pr_code like ? "
					+ " and    date like ? "
					+ " and    update_time like ? "
					+ " and    pr_name like ? "
					+ " and    status like ? "
					+ " order by date asc "
					+ " limit ? , ? ";
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + pageVo.getFindPrcode() + "%");
			ps.setString(2, "%" + pageVo.getFindDate() + "%");
			ps.setString(3, "%" + pageVo.getFindUpdate_time() + "%");
			ps.setString(4, "%" + pageVo.getFindPrname() + "%");
			ps.setString(5, "%" + pageVo.getFindStatus() + "%");
			ps.setInt(6, pageVo.getStartNo());
			ps.setInt(7, pageVo.getListSize());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				OperationVo vo = new OperationVo();
				vo.setDate(rs.getString("date")); 
				 vo.setMachine_no(rs.getString("machine_no"));
				 vo.setManager(rs.getString("manager"));
				 vo.setPr_code(rs.getString("pr_code"));
				 vo.setPr_name(rs.getString("pr_name"));
				 vo.setTaken_time(rs.getString("taken_time")); 
				 vo.setPf(rs.getString("pf"));
				 vo.setStatus(rs.getString("status")); 
				 vo.setUpdate_time(rs.getString("update_time"));
				 vo.setPr_cost(rs.getString("pr_cost"));
				 vo.setReal_price(rs.getString("real_price"));
				 vo.setVat(rs.getString("vat"));
				 vo.setSupply_price(rs.getString("supply_price"));
				list.add(vo);
				
			}	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		close();
		
		return list;
	}
	
	public List<OperationVo> select_stat(PageStat pageVo){
		if(conn == null) conn = new DBConn("operation_management").getConn();
		List<OperationVo> list = new ArrayList<OperationVo>();
		String sql = "";
		//검색된 전체 건수
		try {			
			
			sql =  " select * from om "
					+ " where  pr_code like ? "
					+ " and    date like ? "
					+ " and    update_time like ? "
					+ " and    pr_name like ? "
					+ " and    status like ? "
					+ " order by date asc ";
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + pageVo.getFindPrcode() + "%");
			ps.setString(2, "%" + pageVo.getFindDate() + "%");
			ps.setString(3, "%" + pageVo.getFindUpdate_time() + "%");
			ps.setString(4, "%" + pageVo.getFindPrname() + "%");
			ps.setString(5, "%" + pageVo.getFindStatus() + "%");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				OperationVo vo = new OperationVo();
				vo.setDate(rs.getString("date")); 
				 vo.setMachine_no(rs.getString("machine_no"));
				 vo.setManager(rs.getString("manager"));
				 vo.setPr_code(rs.getString("pr_code"));
				 vo.setPr_name(rs.getString("pr_name"));
				 vo.setTaken_time(rs.getString("taken_time")); 
				 vo.setPf(rs.getString("pf"));
				 vo.setStatus(rs.getString("status")); 
				 vo.setUpdate_time(rs.getString("update_time"));
				 vo.setPr_cost(rs.getString("pr_cost"));
				 vo.setReal_price(rs.getString("real_price"));
				 vo.setVat(rs.getString("vat"));
				 vo.setSupply_price(rs.getString("supply_price"));
				list.add(vo);
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		close();
		
		return list;
	}
	
	public OperationVo view(String pr_code) {
		if(conn == null) conn = new DBConn("operation_management").getConn();
		OperationVo vo = new OperationVo();
		String sql = "select * from om where pr_code = ?";
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pr_code);
			rs = ps.executeQuery();			
			
			 if(rs.next()) { 
				 
			 vo.setDate(rs.getString("date")); 
			 vo.setMachine_no(rs.getString("machine_no"));
			 vo.setManager(rs.getString("manager"));
			 vo.setPr_code(rs.getString("pr_code"));
			 vo.setPr_name(rs.getString("pr_name"));
			 vo.setTaken_time(rs.getString("taken_time")); 
			 vo.setPf(rs.getString("pf"));
			 vo.setStatus(rs.getString("status")); 
			 vo.setUpdate_time(rs.getString("update_time"));
			 vo.setPr_cost(rs.getString("pr_cost"));
			 vo.setReal_price(rs.getString("real_price"));
			 vo.setVat(rs.getString("vat"));
			 vo.setSupply_price(rs.getString("supply_price"));
			
			 }			 
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		close();
		return vo;
	}
	
	public boolean modify(OperationVo vo) {
		if(conn == null) conn = new DBConn("operation_management").getConn();
		boolean b = false;
		
		String sql = " update om set date = ?, status = ?, "
	               + " update_time = ?, pr_cost = ?, "
	               + " real_price = ?, vat = ?, supply_price = ? where pr_code = ? ";
	      
	      try {
	         conn.setAutoCommit(false);
	         ps = conn.prepareStatement(sql);
	         ps.setString(1, vo.getDate());//
	         ps.setString(2, vo.getStatus());//
	         ps.setString(3, vo.getUpdate_time());
	         ps.setString(4, vo.getPr_cost());
	         ps.setString(5, vo.getReal_price());
	         ps.setString(6, vo.getVat());
	         ps.setString(7, vo.getSupply_price());
	         ps.setString(8, vo.getPr_code());
			

	
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
	
	public boolean delete(OperationVo vo) {
		if(conn == null) conn = new DBConn("operation_management").getConn();
		boolean b = false;
		String sql = "delete from om where pr_code = ?";
		try {
			conn.setAutoCommit(false);
			
			 ps = conn.prepareStatement(sql); 
			 ps.setString(1, vo.getPr_code());			 
			
			int cnt = ps.executeUpdate();
			
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
