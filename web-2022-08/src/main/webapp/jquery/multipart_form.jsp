<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/multipart_form.jsp</title>
</head>
<body>
<h2>Multipart Form</h2>
<form class='frm' id='frm' enctype='multipart/form-data'>
	<label>작성자</label>
	<input type='text' name='id' value='홍길자'/><br/>
	<label>첨부파일</label>
	<input type="file" name='att' value='파일 선택' multiple/>
	<input type='button' id='btnSend' value='파일 전송'/>
</form>
<form class='frm'>
	<label>작성자</label>
	<input type='text' name='id' value='홍길자1'/><br/>
	<label>첨부파일</label>
	<input type="file" name='att' value='파일 선택' multiple/>
	<input type='button' id='btnSend' value='파일 전송'/>
</form>
<fieldset>
	<legend>전송 결과</legend>
	<div id='result'></div>
</fieldset>
<script>
$('#btnSend').on('click',function(){
	var data = new FormData($('.frm')[0]);
	$.ajax({
		type : 'POST',
		url	 : '../ajaxFileUpload.do',
		contentType : false,		// contentType과 processData를 false로 지정해야 object타입으로 전송한다.
		processData : false,
		data : data,	
		dataType : 'json',			// 수신 데이터의 형식
		// function(receiveData) = xhr.responseText
		success : function(receiveData){		// success = (xhr.status==200 && xhr.readyState == 4)
			var str = '<ul>';
			str += '<li>첨부파일'
				+	'<ol>';
			for(f of receiveData.att){
				str += '<li>' + f + '</li>';
			}
			str += '</ol>'
				+ '<li>id : ' + receiveData.id + '</li>'
				+ '<li>msg : ' + receiveData.msg + '</li>'		
				+ '</ul>';
			$('#result').html(str); 			
		}	 
	})
	
	var data1 = new FormData($('.frm')[1]);
	$.ajax({
		type : 'POST',
		url	 : '../ajaxFileUpload.do',
		contentType : false,		// contentType과 processData를 false로 지정해야 object타입으로 전송한다.
		processData : false,
		data : data1,	
		dataType : 'json',			// 수신 데이터의 형식
		// function(receiveData) = xhr.responseText
		success : function(receiveData){		// success = (xhr.status==200 && xhr.readyState == 4)
			var str = '<ul>';
			str += '<li>첨부파일'
				+	'<ol>';
			for(f of receiveData.att){
				str += '<li>' + f + '</li>';
			}
			str += '</ol>'
				+ '<li>id : ' + receiveData.id + '</li>'
				+ '<li>msg : ' + receiveData.msg + '</li>'		
				+ '</ul>';
			$('#result').append(str); 			
		}	 
	})
})
</script>
</body>
</html>