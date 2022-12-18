<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp/useBean2.jsp</title>
</head>
<body>
<h2>[미션] useBean 태그를 사용한 처리</h2>
<form name='frm_useBean' method='post' action='useBean2_result.jsp'>
	<span>아이디: </span>
	<input type='text' size='10' name='id' autocomplete='off'/></br>
	<span>국어 점수: </span>
	<input type='text' size='7' name='kor' autocomplete='off'/></br>
	<span>영어 점수: </span>
	<input type='text' size='7' name='eng' autocomplete='off'/></br>
	<span>수학 점수: </span>
	<input type='text' size='7' name='mat' autocomplete='off'/>
	<input type='submit'/>

</form>
</body>
</html>