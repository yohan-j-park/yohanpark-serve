<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int dan = Integer.parseInt(request.getParameter("dan"));
	String r = "";
	for(int i=1; i<10; i++){
		String temp = String.format("%d * %d = %d<br/>", dan, i, (dan*i));
		r += temp;
	}
		out.print(r);
%>