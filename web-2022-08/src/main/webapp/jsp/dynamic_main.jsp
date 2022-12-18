<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/dynamic_main</title>
</head>
<body>
<h2>동적 삽입 메인 페이지</h2>
<% 
String url="dynamic_sub.jsp";
%>
<%
String test = "test";
%>
<jsp:include page="<%=url %>">
	<jsp:param value="홍길동" name="irum"/>
	
</jsp:include>

<hr/>

<jsp:include page="dynamic_sub2.jsp">
	<jsp:param value="99" name="dan"/>
</jsp:include>


<h2>메인 페이지 꼬릿말</h2>
</body>
</html>