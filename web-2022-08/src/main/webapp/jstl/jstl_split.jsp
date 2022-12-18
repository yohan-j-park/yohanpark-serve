<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl/jstl_split.jsp</title>
</head>
<body>
<h3>jstl:functions</h3>
<c:set var='source' value='개나리,진달래,장미,코스모스,백합'/>
<c:set var='result' value="${fn:split(source,',') }"/>
result = ${result }<br/>
<c:forEach var='i' items='${result }' varStatus= 'status'>
	${i } - ${status.index } - ${status.count }<br/>
</c:forEach>
<br/>

<c:set var='join' value="${fn:join(result,'****') }"/>
join = ${join }
</body>
</html>