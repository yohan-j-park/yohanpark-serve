<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/login.jsp</title>
</head>
<body>
<div class='frm_login'>
	<form name='frm_login' method='post' action = 'member/login_result.jsp'>
		<span>아이디</span>
		<input type='text' name='mId' value='a005'/><br/>
		<span>암호</span>
		<input type='password' name='pwd' value='1111'/><br/>
		<input type='submit' value='로그인'/>
		<a href='http://192.168.35.63:8888/web-2022-08/member/findpwd.jsp'>암호찾기</a>
	</form>
</div>

<script>

</script>
</body>
</html>