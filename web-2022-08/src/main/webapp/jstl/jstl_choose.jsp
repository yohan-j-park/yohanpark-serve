<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/jstl_choose.jsp</title>
</head>
<body>
<%
	int v = 86;
	request.setAttribute("v", v);
%>
<div style='border:3px solid #00f; padding:10px; width:300px; border-radius:10px; background-color:lightblue;'>
	당신의 성적은 ${v }이며, 등급은
	<c:choose>
		<c:when test='${v >= 90 }'>'A'</c:when>
		<c:when test='${v >= 80 }'>'B'</c:when>
		<c:when test='${v ge 70 }'>'C'</c:when>
		<c:when test='${v ge 60 }'>'D'</c:when>
		<c:when test='${v ge 50 }'>'E'</c:when>
		<c:otherwise>'F'</c:otherwise>
	</c:choose>
	입니다.
</div>
</body>
</html>