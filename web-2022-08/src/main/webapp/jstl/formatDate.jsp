<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/formatDate.jsp</title>
</head>
<body>
<h2>formatDate || parseDate</h2>
<c:set var='now' value='<%=new Date() %>'/>
<fmt:formatDate value="${now }" type='both' dateStyle='full'/> : both/full<br/>
<fmt:formatDate value="${now }" type='both' dateStyle='short'/> : both/short<br/>
<fmt:formatDate value="${now }" type='both' dateStyle='medium'/> : both/medium<br/>
<fmt:formatDate value="${now }" type='both' dateStyle='long'/> : both/long<br/>
<hr/>

<fmt:formatDate value="${now }" type='date' dateStyle='full'/> : date/full<br/>
<fmt:formatDate value="${now }" type='date' dateStyle='short'/> : date/short<br/>
<fmt:formatDate value="${now }" type='date' dateStyle='medium'/> : date/medium<br/>
<fmt:formatDate value="${now }" type='date' dateStyle='long'/>: date/long<br/>
<hr/>

<fmt:formatDate value="${now }" pattern="yyyy-MM-dd (E) HH:mm:ss"/><br/>
<hr/>

<fmt:parseDate value="2022-11-07 12:12:12" pattern="yyyy-MM-dd HH:mm:ss"/>



</body>
</html>