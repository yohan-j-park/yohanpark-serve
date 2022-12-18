<%@page import="student.StudentVo"%>
<%@page import="java.util.List"%>
<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 조회</title>
<link rel='stylesheet' href='./student/(강사님ver)student.css'>
<script defer src='js/student.js'></script>
</head>
<body>
<jsp:useBean id="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>
<%
StudentDao dao = new StudentDao();
List<StudentVo> list = dao.select(pageVo);
%>


<div id='std_list'>
	<h2>학생정보 조회</h2>
	<form name='frm_search' method='post'>
		<input type='button' value='입력' name='btnInsert'/>
		<input type='search' name='findStr' size='40' value="<%=pageVo.getFindStr()%>"/>
		<input type='button' value='조회' name='btnSelect'/>
		<input type='text' name='nowPage' value="<%=pageVo.getNowPage()%>"/>
	</form>
	<ul>
		<li class='title'> <!-- 타이틀 영역 -->
			<span class='no'>No</span>
			<span class='id'>아이디</span>
			<span class='name'>성명</span>
			<span class='gender'>성별</span>
			<span class='phone'>연락처</span>
			<span class='address'>주소</span>
			<span class='email'>이메일</span>
			<span class='zipcode'>우편번호</span>
		</li>
		<% for(int i=0; i<list.size(); i++){ 
			StudentVo v = list.get(i);
		%>
			<li class='item' onclick = "view('<%=v.getId()%>')"> <!-- Id는 문자라 v.getId()를 ''로 감싸야 한다. --> 
				<span class='no'><%=i+1 %></span>
				<span class='id'><%=v.getId() %></span>
				<span class='name'><%=v.getName() %></span>
				<span class='gender'><%=v.getGender() %></span>
				<span class='phone'><%=v.getPhone() %></span>
				<span class='address'><%=v.getAddress() %></span>
				<span class='email'><%=v.getEmail() %></span>
				<span class='zipcode'><%=v.getZipcode() %></span>
		<%} %>
		<li class='btn_page'> <!-- page이동 버튼 -->
		<%if(pageVo.getStartPage()>1){ %>  <!-- 현재 보고있는 페이지가 첫페이지일때 처음,이전버튼 없애기 -->
			<input type='button' value='처음' onclick='movePage(1)'/>
			<input type='button' value='이전' onclick='movePage(<%=pageVo.getStartPage()-1%>)'/>
			<%} %>
			<%for(int i=pageVo.getStartPage(); i<=pageVo.getEndPage(); i++){ %>
				<input type='button' value='<%=i %>' onclick='movePage(<%=i %>)'/>
			<%} %>	
		<%if(pageVo.getTotPage()>pageVo.getEndPage()){ %> <!-- 현재 보고있는 페이지가 마지막일 때 다음,맨끝버튼 없애기 -->	
			<input type='button' value='다음' onclick='movePage(<%=pageVo.getEndPage()+1 %>)'/>
			<input type='button' value='맨끝' onclick='movePage(<%=pageVo.getTotPage()%>)'/>
			<%} %>
			
		</li>
		
	</ul>
</div>


</body>
</html>