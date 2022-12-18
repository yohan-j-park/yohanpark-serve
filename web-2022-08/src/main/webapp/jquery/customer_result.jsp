<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.DBConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String findStr = request.getParameter("findStr");
Connection conn = new DBConn().getConn();
PreparedStatement ps = null;
ResultSet rs = null;
JSONArray jsonArray = new JSONArray();

String sql = "select customernumber,customername,phone,addressLine1 " 
			 +" from customers where customername like ? or phone like ? ";

ps = conn.prepareStatement(sql);
ps.setString(1, "%" + findStr + "%");
ps.setString(2, "%" + findStr + "%");

rs = ps.executeQuery();

while(rs.next()){
	JSONObject obj = new JSONObject();
	obj.put("customernumber", rs.getString("customernumber"));
	obj.put("customername", rs.getString("customername"));
	obj.put("phone", rs.getString("phone"));
	obj.put("addressLine1", rs.getString("addressLine1"));
	
	jsonArray.add(obj);
}
%>
<%=jsonArray.toJSONString() %>
