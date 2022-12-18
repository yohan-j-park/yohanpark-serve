<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id = "pageVo" class = "operation.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<jsp:useBean id = "vo" class = 'operation.OperationVo'/>
<jsp:setProperty property="*" name="vo"/>

<%
	request.setAttribute("vo", vo);
	request.setAttribute("pageVo", pageVo);
%>

<jsp:forward page="operation.do"/>
