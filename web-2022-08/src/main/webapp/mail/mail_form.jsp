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
 <h1>메일 쓰기</h1>
 <form name='form_mail' method='post'>
   <label>수 신</label><input type='text' name='receiver' value="p_yohan@naver.com"><br/>
   <label>제 목</label><input type='text' name='subject'  value="방가..."><br/>
   <div class='content'>
   <label>내 용</label><textarea rows="5" cols="60" name="content">ㅋㅋㅋ</textarea>
   <input type='hidden' name='sender'>
   </div>
   <hr/>
   <div class='btn'>
    <input type='button' value='메일전송(네이버)' onclick="sendMail()"> 
   </div>
 </form>
 <div class='msg'>
  ${msg }
 </div>
</div> 

<script>
 var frm = document.form_mail;
 function sendMail(){
  frm.sender.value="p_yohan@naver.com";
  frm.action='../SendNaverServlet.do';
  frm.submit();
 }
</script>
</body>
</html>