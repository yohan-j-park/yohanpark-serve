<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/post.jsp</title>
<script src ='../lib/jquery-3.6.1.min.js'></script>
</head>
<body>
<h2>POST</h2>
<form name='frm' method='post'>
	<label>작성자</label>
	<input type='text' name='id' value='a001'/><br/>
	<label>제목</label>
	<input type='text' name='subject' value='제목'/><br/>
	<textarea cols='40' rows='5' name='doc'></textarea><br/>
	<input type='button' value='전송' id='btnSend'/>
</form>
<hr/>
<div id='result'></div>

<script>
// $(document).ready(function(){}) : script를 아래에서 사용하면 굳이 쓰지 않아도 됨
$('#btnSend').on('click',function(){
	var param = $('form').serialize();
	$.post('post_result.jsp',param,function(data){
		$('#result').html(JSON.stringify(data));
		console.log('id',data.id);
		console.log('subject',data.subject);
		console.log('doc',data.doc);
	},'json')
})
</script>
</body>
</html>