<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>servlet/jap.jsp</title>
</head>
<body>
<h2>Servlet 으로 만든 계산기</h2>

<%
double d = 0;
double su1 = 0;
double su2 = 0;

if(request.getAttribute("hap") != null){
	su1 = (double)request.getAttribute("su1");
	su2 = (double)request.getAttribute("su2");
	
}


%>
<form name='frm' method='post' action='hap.do'>
	<textarea rows="5" cols="30" name='result' value ='<%=d %>'></textarea><br/>
	<input type='text' name='su1' value='<%=su1 %>'/><br/>
	<input type='text' name='su2' value='<%=su2 %>'/><br/>
	<input type='button' name='btn' value='plus(+)' onclick='run(this.value)'/>
	<input type='button' name='btn' value='minus(-)'onclick='run(this.value)'/>
	<input type='hidden' name='oper'/>
</form>

<script>
function run(oper){
	let frm = document.frm;
	frm.oper.value=oper;
	frm.submit();
}

</script>
</body>
</html>