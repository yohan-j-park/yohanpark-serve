<%@page import="student.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/scope.jsp</title>
</head>
<body>
<%
StudentVo vo = new StudentVo();
vo.setId("a001");
vo.setName("hong");
vo.setPhone("010-1111-1111");

request.setAttribute("vo", vo);

%>

<ul>
	<li>id : <%=vo.getId() %></li>
	<li>name : <%=vo.getName() %></li>
	<li>phone : <%=vo.getPhone() %></li>
</ul>
<hr/>

<ul>
	<li>id : ${vo.id }</li>
	<li>name : ${vo.name }</li>
	<li>phone : ${vo.phone }</li>

</ul>
</body>
</html>