<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mail/mail_form.jsp</title>
<style>
 #mail{
  width:500px;
  border:3px solid #aaa;
  margin:auto; 50px;
  padding:30px;
 }
 input[type=text]{ width: 450px;}
 textarea{ width: 450px;}
 div>label{ vertical-align: top;}
 .btn{ 
  width:100%;
  text-align: center;
 }
 .msg{
  margin:30px;
  text-align: center;
 }
</style>
</head>
<body>
<div id='mail'>
 <h1>암호 찾기</h1>
 <form name='form_mail' method='post' action='../SendPwdServlet.do'>
   <label>아이디</label><input type='text' name='mid'  value="a005"><br/>
   <label>이메일 <font color='grey'>(*암호찾기 메일은 가입 시 입력한 이메일로 전송됩니다.)</font></label>
   <input type='text' name='email' value="p_yohan@naver.com"><br/>
   <div class='content'>
   <!-- <input type='hidden' name='sender' value="p_yohan@naver.com" -->>
   </div>
   <hr/>
   <div class='btn'>
    <input type='button' value='암호 찾기' name='btnCheck'> 
   </div>
 </form>
 <div class='msg'>
 
 </div>
</div> 

<script>
var frm = document.form_mail;
frm.btnCheck.onclick = function(){
	var xhr = new XMLHttpRequest();
	var param = `?mid=\${frm.mid.value}&email=\${frm.email.value}`;
	console.log(param);
	xhr.open('post', '../SendPwdServlet.do'+param);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status == 200 && xhr.readyState == 4){
			var data = xhr.responseText;
			var msg = document.querySelector('.msg');
			msg.innerHTML = data;
		}
	}
}
</script>
</body>
</html>