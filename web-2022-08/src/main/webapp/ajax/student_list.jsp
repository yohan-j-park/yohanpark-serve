<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jdbc.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String findStr = request.getParameter("findStr");
	Connection conn = new DBConn("mydb").getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	JSONArray jsonArray = new JSONArray();
	
	String sql = "select * from student where name like ? or phone like ?";
	ps = conn.prepareStatement(sql);
	ps.setString(1, "%" + findStr + "%");
	ps.setString(2, "%" + findStr + "%");
	
	rs = ps.executeQuery();
	while(rs.next()){
		JSONObject obj = new JSONObject();
		obj.put("id", rs.getString("id"));
		obj.put("name", rs.getString("name"));
		obj.put("phone", rs.getString("phone"));
		obj.put("address", rs.getString("address"));
		
		jsonArray.add(obj);
	}
	out.print(jsonArray.toJSONString());	
%>