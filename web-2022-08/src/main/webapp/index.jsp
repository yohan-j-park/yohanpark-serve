<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>웹 프로젝트</title>
		<link rel='stylesheet' href='css/index답안.css'>
	</head>
	<body>
	<%
	String inc="temp.html";
	if(request.getParameter("inc") != null){
		inc = request.getParameter("inc");
	} 
	String sessionId = (String)session.getAttribute("sessionId");
	%>
		<main>
			<div class='login'>
			<%if(sessionId == null){ %>
				<a href='index.jsp?inc=member/login.jsp'>로그인</a>
			<% } else{ %>
				[<%=sessionId %> 님 방가] 
				<a href='member/logout.jsp'>로그아웃</a>
			<%} %>	
			</div>
		
			<header>
				
			<img src='images/농담곰3.jpg'
				 width='250px'
				 height='120px'/>
				<nav>
					<a href='index.jsp?inc=student/(강사님ver)student_list.jsp'>학생관리</a>
					<a href='index.jsp?inc=javascript/score_crud.html'>성적관리</a>
					<a href='index.jsp?inc=member/member_control.jsp'>회원관리</a>
					<a href='#'>제품관리</a>
					<a href='#'>생산관리</a>
					<a href='#'>방명록</a>
					<a href='#'>게시판</a>
				</nav>
			</header>
			<div class='content'>
				<jsp:include page="<%=inc %>"/>
			</div>
			<footer>
				대한민국
			</footer>
		</main>

	</body>
</html>