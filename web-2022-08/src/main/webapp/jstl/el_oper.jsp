<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/el_oper.jsp</title>
</head>
<body>
<div>el에서 사용할 수 있는 연산자</div>
<c:set var='kor' value='90'/>
<c:set var='eng' value='80'/>
<c:set var='tot' value='${kor+eng }'/>
<c:set var='avg' value='${tot/2 }'/>
<ul>
	<li>kor = ${kor }</li>
	<li>eng = ${eng }</li> 
	<li>tot = ${tot }</li>
	<li>avg = ${avg }</li>
	<li>result = ${avg ge 80 ? 'pass' : 'fail' }</li>
	
</ul>
</body>
</html>