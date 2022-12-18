<%@page import="crypto.AES"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sec/aes_test.jsp</title>
</head>
<body>
<%
AES aes = new AES();
String msg = "abc 123 가나다";
String enc = aes.encrypt(msg);	//암호화
String dec = aes.decrypt(enc);	//복호화
%>
<ul>
	<li>원본 : <%=msg %></li>
	<li>암호화 : <%=enc %></li>
	<li>복호화 : <%=dec %></li>
</ul>
</body>
</html>