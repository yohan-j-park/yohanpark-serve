<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>web_socket.jsp</title>
<script src='../lib/jquery-3.6.1.min.js'></script>
<style>
#web_client{
	width:800px;
	margin:30px auto;
}
#result{
	width:100%;
	height:300px;
	border: 2px solid #aaa;
	box-sizing:border-box;
	padding:20px;
	overflow:auto;
}
#msg{
	width:730px;
}
</style>
</head>
<body>
<div id='web_client'>
	<h2>WebSocket을 사용한 채팅 웹</h2>
	<div id='result'></div>
	<input type='text' id='msg'/>
	<input type='button' value='전송' id='btnSend'/>
</div>

<script>
	var websocket = new WebSocket('ws://localhost:8888/web-2022-08/chatting');
	
	websocket.onopen = function(){		
		$('#result').html('연결 성공!!');
		/*
		let rs = document.querySelector('#result'); 
		rs.innerHTML = '연결 성공';
		*/
	}
	websocket.onmessage = function(msg){
		let str = '<div>' + msg.data + '</div>';
		$('#result').append(str);
	}
	websocket.onclose = function(){		
		$('#result').html('연결 종료');
	}  
	$('#msg').keyup(function(ev){
		if(ev.keyCode==13) sendFunc();
	});
	$('#btnSend').click(sendFunc);
	
	function sendFunc(){
		let msg = $('msg').val();
		websocket.send(msg);
		console.log('msg: ', $('#msg'));
	}
	
</script>
</body>
</html>