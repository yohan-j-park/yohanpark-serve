<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/import_main.jsp</title>
<style>
h3{text-align:center;}
</style>
</head>
<body>
<fieldset>
<legend><h2>import main page</h2></legend>
<c:import url="import_sub.jsp" var='page'>
	<c:param name='id' value='a001'/>
	<c:param name='phone' value='010-1234-5678'/>
</c:import>
${page }
<h3>footer</h3>
</fieldset>
</body>
</html>