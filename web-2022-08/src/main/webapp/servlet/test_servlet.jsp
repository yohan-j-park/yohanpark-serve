<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servlet/test_servlet.jsp</title>
</head>
<body>
<h2>Servlet 호출하기</h2>
<a href = "sbs.kr?id=hong&phone=010-1111">SBS</a><br/>

<h2>form:get</h2>
<form method='get' action='sbs.kr'>
	<span>Id</span>
	<input type='text' name='id' value='kim'/><br/>
	<span>Phone</span>
	<input type='text' name='phone' value='010-1111-1111'/><br/>
	<input type='submit' value='SBS'/>
</form>
<br/>


<h2>form:post</h2>
<form method='post' action='mbc.kr'>
	<input type='text' name='id' value='kim'/><br/>
	<span>Phone</span>
	<input type='text' name='phone' value='010-1111-1111'/><br/>
	<br/>
	<input type='submit' value='MBC'/>
</form>
</body>
</html>