<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/get.jsp</title>
<script src ='../lib/jquery-3.6.1.min.js'></script>
<script>
$(document).ready(function(){
	var param = "id=hong&pwd=1234&msg=방가...";
	$.get('get_json.jsp',param,function(data){
		console.log('id',data.id);
		console.log('pwd',data.pwd);
		console.log('msg',data.msg);
		$('#result').html(JSON.stringify(data));
	}, 'json')
})
</script>
</head>
<body>
<div id='result'></div>
</body>
</html>