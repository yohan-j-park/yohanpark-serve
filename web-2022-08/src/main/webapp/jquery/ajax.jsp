<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/ajax.jsp</title>
<script src ='../lib/jquery-3.6.1.min.js'></script>
</head>
<body>
<h3>$.ajax를 사용한 파일 로드</h3>
<input type='button' value='$.ajax' id='btn'/>
<div id='result'></div>

<script>
	$(document).ready(function(){
		$('#btn').on('click',function(){
			$.ajax({
				'type' : 'post',
				'url' : 'load_test.jsp;',
				'dataType' : 'html',
				'success' : function(receiveData, status){
					$('#result').html(receiveData); 	// text(receiveData)도 있음
				},
				error : function(xhr,status,err){
					alert(status + ',' + err);
				}
			})
		})
	});
</script>
</body>
</html>
