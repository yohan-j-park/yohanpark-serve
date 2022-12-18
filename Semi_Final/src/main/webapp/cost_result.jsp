<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<jsp:useBean id = "vo" class = 'operation.CostVo'/>
<jsp:setProperty property="*" name="vo"/>

<%
	request.setAttribute("vo", vo);
%>

<jsp:forward page="cost.do"/>
