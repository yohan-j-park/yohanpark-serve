<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis/bean.jsp</title>
</head>
<body>
<jsp:useBean id="bVo" class="member.MemberVo"/>
<jsp:useBean id="pVo" class='member.MybatisPageVo'/>
<jsp:setProperty property="*" name="bVo"/>
<jsp:setProperty property="*" name="pVo"/>
<%
request.setAttribute("bVo", bVo);
request.setAttribute("pVo", pVo);
%>
<jsp:forward page="mms.do"/>
</body>
</html>