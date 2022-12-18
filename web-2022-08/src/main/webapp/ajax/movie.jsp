<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* 상영관에 따른 영화제목을 JSONArray로 반환 */
JSONArray movie = new JSONArray();
String theater = request.getParameter("theater");
switch(theater){
	case "서울A":
	case "부산A":
	case "대구A":
		movie.add("영화제목 1");
		movie.add("영화제목 2");
		break;
	case "서울B":
	case "부산B":
		movie.add("영화제목 3");
		movie.add("영화제목 4");
		break;
	case "서울C":
	case "부산C":
		movie.add("영화제목 5");
		movie.add("영화제목 6");
		break;
	case "서울D":
		movie.add("영화제목 7");
		movie.add("영화제목 8");
		break;
	case "서울E":
		movie.add("영화제목 9");
		movie.add("영화제목 10");
		break;
}
out.print(movie.toJSONString());
%>