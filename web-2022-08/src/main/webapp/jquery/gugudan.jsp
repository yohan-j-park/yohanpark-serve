<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/gugudan.jsp</title>
</head>
<body>
<input type='text' id='dan' value='5'/>
<input type='button' id='btnResult' value='단 출력'/>	
<div id='gugudanResult'></div>

<script>
$('#btnResult').on('click',function(){
	var dan = $('#dan').val();
	$('#gugudanResult').load('gugudan_result.jsp?dan='+dan);
})
</script>
</body>
</html>