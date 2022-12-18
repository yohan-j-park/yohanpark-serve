<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/static_main</title>
</head>
<body>
<h2>정적 삽입</h2>
<%
String v = "메인에서 선언 된 변수";
%>

<%@include file="static_sub.jsp" %>
<hr/>
위에 표시 된 페이지는 정적으로 삽입 된 페이지입니다.
</body>
</html>