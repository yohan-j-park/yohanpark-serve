<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* 지역에 따른 상영관을 JSONArray로 반환 */
JSONArray theater = new JSONArray();
String city = request.getParameter("city");
switch(city){
	case "서울":
		theater.add("서울A");
		theater.add("서울B");
		theater.add("서울C");
		theater.add("서울D");
		theater.add("서울E");
		break;
	case "부산":
		theater.add("부산A");
		theater.add("부산B");
		theater.add("부산C");
		theater.add("부산D");
		break;
	case "대구":
		theater.add("대구A");
		theater.add("대구B");
		break;
}
out.print(theater.toJSONString());
%>