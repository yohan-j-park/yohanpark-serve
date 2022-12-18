<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/login.jsp</title>
<link rel="stylesheet" href="css/login_css.css">
<script defer src="js/login.js"></script>

<script>

//엔터키 누르면 로그인
   var ID = document.querySelector('#ID');

function EnterLogin(){
   var loginBtn = document.querySelector('#loginBtn');
   var PWD = document.querySelector('#PWD');
   var login = document.querySelector('#login');

   var keyCode = window.event.keyCode;
      if(keyCode == 13) {
            login.submit();
         }
     }


</script>

</head>
<body onkeydown = "javascript : EnterLogin()" > 
<div class="login-box">
   <h2>Login</h2>
    <form id = 'login' name='frm_login' method='post'>
       <div class="user-box">
           <input type='text' name='mId' id='ID' required/>
           <label>아이디</label>
        </div>
        <div class="user-box">
            <input type='password' name='pwd' id='PWD' required/>
            <label>비밀번호</label>
        </div>
        <div class ="alert">
        
        </div>
        <a href="#" id='loginBtn' onclick='login()'>>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            로그인
        </a>
   </form>
</div>

    
</body>
</html>