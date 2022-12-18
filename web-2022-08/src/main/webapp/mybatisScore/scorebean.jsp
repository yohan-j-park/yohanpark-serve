<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatisScore/scorebean.jsp</title>
</head>
<body>
<jsp:useBean id="bVo" class="score.ScoreVo"/>
<jsp:useBean id="pVo" class='score.ScorePageVo'/>
<jsp:setProperty property="*" name="bVo"/>
<jsp:setProperty property="*" name="pVo"/>
<%
request.setAttribute("bVo", bVo);
request.setAttribute("pVo", pVo);
%>
<jsp:forward page="scoreServlet.do"/>
</body>
</html>