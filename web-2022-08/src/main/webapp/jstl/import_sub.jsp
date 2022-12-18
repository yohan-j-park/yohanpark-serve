<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/import_sub.jsp</title>
<style>
legend{
	text-align:center;
}
</style>
</head>
<body>
<fieldset>
<legend>이 부분은 import된 페이지 내용입니다.<br/></legend>
<ul>
	<li>id : ${param.id }</li>
	<li>phone : ${param.phone }</li>
</ul>
</fieldset>
</body>
</html>