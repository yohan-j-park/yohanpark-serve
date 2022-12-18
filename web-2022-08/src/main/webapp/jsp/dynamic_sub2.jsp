<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/dynamic_sub2.jsp</title>
</head>
<body>
<%
	int dan=Integer.parseInt(request.getParameter("dan"));	// request로 받은 parameter는 무조건 문자열이다.
	for(int i=1; i<10; i++){
		int r=dan*i;
		out.print(r + " ");
	}
%>

</body>
</html>