<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/dynamic_sub.jsp</title>
</head>
<body>
<%
String irum = request.getParameter("irum");
%>
<div>
나의 이름은 "<%=irum %>"입니다.
</div>
</body>
</html>