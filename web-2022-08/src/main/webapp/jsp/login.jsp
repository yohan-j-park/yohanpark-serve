<%@page import="jdbc.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<%	// request.getMethod().equals("") : 요청방식 확인하는 것. equals 안에 ""에는 전부 대문자로 써야한다.

	if(request.getMethod().equals("POST")){		// 페이지를 새로 접속하면 method가 get이다.(get type은 url에 뒤에 적는다)
		String mId = request.getParameter("mId");
		Login l = new Login();
		boolean b = l.login(mId, "");
		
		if(b){
		session.setAttribute("mId",mId);
		session.setMaxInactiveInterval(5);
		}else{
			out.print("<script>alert('저리꺼져')</script>");
		}
	}

	// 세션아이디가 있으면 로그인 한 후, 세션아이디가 없으면 로그인 전
	String sessionId = (String)session.getAttribute("mId");
	

%>
<!-- 
http는 클라이언트에서 서버로 요청, 서버에서 클라이언트로 응답이 진행되면 연결을 해제한다. 따라서 기존 정보를 유지하기 위하여
Session이라는 객체를 사용해서 해당 정보를 저장한다.
Session에 값을 저장할때는 setAttribute(String name, Object value);를 사용하여 저장하고
Session에 저장한 값을 불러올 때는 getAttribute(String name)이라는 메소드를 사용한다.
 -->

<form name='frm_login' method='post'>	
<!-- form태그의 method는 get과 post중 선택. get은 보안상 취약하기때문에 중요한 정보는 post방식으로 요청  -->
	<%if(sessionId==null){ %>
		<span>아이디</span>
		<input type='text' name='mId' value='a001' autocomplete="off"/>
		<span>암 호</span>
		<input type='password' name='pwd' value='1111'/>
		<input type='button' value='로그인' name='btnLogin'/>
	<%}else{ %>
	<span><%=sessionId %>님 방가</span>
	<input type='button' value='로그아웃' name='btnLogout'/>
	<%} %>
</form>

<script>
var frm = document.frm_login;
 if(frm.btnLogin != null){
	frm.btnLogin.onclick = function(){
		frm.action="login.jsp";		
		// 로그인 버튼을 클릭하면 자기 자신을 실행함
		// form태그의 action속성은 form data를 서버로 보낼 때 해당 데이터가 도착할 URL을 명시합니다.
		
		frm.submit();	// 자기 자신을 제출함
	}
}

 if(frm.btnLogout != null){

	frm.btnLogout.onclick = function(){
		frm.action = "logout.jsp";
		frm.submit();	//logout page를 호출함
	}
}
</script>
</body>
</html>