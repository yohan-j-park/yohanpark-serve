<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/el.jsp</title>
</head>
<body>
<%
	String findStr1 = request.getParameter("findstr");
%>
<h2>EL TEST</h2>
<form name='frm' method='post'>
	<span>Value</span>
	<input type='text' name='findstr' value='${param.findstr}'/>
	<input type='text' name='findstr' value='<%=findStr1 %>'/>
	<input type='submit'/>
</form>
</body>
</html>