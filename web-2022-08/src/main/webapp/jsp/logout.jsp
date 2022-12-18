<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logout.jsp</title>
</head>
<body>
<%
	session.setAttribute("mId", null);
	// session.invalidate(); : 세션에 있는 '모든' 값을 삭제하는 메소드
	
	// 특정 조건일 때에 지정한 페이지로 이동하고 싶을 때 쓰는 메소드 
	response.sendRedirect("login.jsp");

%>
</body>
</html>