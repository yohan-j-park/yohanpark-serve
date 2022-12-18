<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/jstl_forEach.jsp</title>
</head>
<body>
<h2>forEach를 일반 for문처럼 사용하기</h2>
<c:forEach var='i' begin='1' end='10'>
${i }
</c:forEach>

<h2>배열에 값을 담아 출력</h2>
<%
String[] ani={"강아지","송아지","망아지","도야지","호랑이"};
request.setAttribute("ani",ani);
%>
<c:forEach items='${ani }' var='i'>
	'${i }'
</c:forEach>
<br/>
<c:forEach items='${ani }' var='i' begin='2' end='3'>
	${i }
</c:forEach>
<br/>
<c:forEach items='${ani }' var='i' varStatus='status' begin='2' end='4'>
	<li>${i } -- ${status.current } -- ${status.index } -- ${status.count }</li>
</c:forEach>
<br/>
<%
List<String> list = new ArrayList<String>(Arrays.asList(ani));
request.setAttribute("list",list);
%>
<h2>List Collection</h2>
<c:forEach items='${list }' var='i' varStatus='status'>
	<li>${i } -- ${status.current } -- ${status.index } -- ${status.count }</li>
</c:forEach>
</body>
</html>