<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/student_input_result.jsp</title>
</head>
<body>
<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<jsp:useBean id="studentVo" class="student.StudentVo"/>
<jsp:setProperty property="*" name="studentVo"/>

<form name='frm' method='post'>
	<input type='text' name='findStr' value="<%=pageVo.getFindStr() %>">
	<input type='text' name='nowPage' value="<%=pageVo.getNowPage() %>">
</form>

<%
StudentDao dao = new StudentDao();
boolean b = dao.insert(studentVo);
if(!b){%>
  <script>
  		alert('자료 저장 중 오류 발생');
 </script>  	
 <% }%>
  
<script>
	var frm = document.frm;
	frm.action="index.jsp?inc=student/(강사님ver)student_list.jsp";
	frm.submit();
</script>
  
</body>
</html>