<%@page import="jdbc.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/login_result.jsp</title>
</head>
<body>
<%
String mId = request.getParameter("mId");
String pwd = request.getParameter("pwd");
Login l = new Login();
boolean b = l.login(mId,pwd);
if(b){
	session.setAttribute("sessionId", mId);
	session.setAttribute("sessionPwd", pwd);
	response.sendRedirect("../index.jsp");
}else{
	out.print("<script>alert('넌 누구??');</script>");
	out.print("<a href='../index.jsp'>홈으로</a>");
}


%>
</body>
</html>