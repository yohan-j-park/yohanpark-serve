<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='member.css'>
<title>mybatis/member_select.jsp</title>
<script defer src='member.js'></script>
</head>
<body>
<div id='member'>
	<h2>회원관리</h2>
	<form name='frm' method='post' class='frm'>
		<input type='button' value='입력' class='btnInsert'/>
		<input type='search' name='findStr' value="${pVo.findStr }" autocomplete='off'/>
		<input type='button' value='검색' class='btnSearch'/>
		<input type='hidden' name='nowPage' value='${pVo.nowPage }'/>	<!-- 나중에 히든으로 바꾸기 -->
		<input type='hidden' name='id'/>	<!-- 나중에 히든으로 바꾸기 -->
	</form>
	<br/>
	<div class='item_title' style='background-color:#1b2035;'>
		<span class='no'>NO</span>
		<span class='id'>아이디</span>
		<span class='name'>성명</span>
		<span class='gender'>성별</span>
		<span class='phone'>연락처</span>
		<span class='mdate'>가입일</span>
	</div>
	<div class='item_list'>
		<c:set var="no" value="0"/>
		<c:forEach var='vo' items="${list }" varStatus="status">
			<div class='item' onclick="view('${vo.id}')">
				<span class='no'>${status.count + pVo.startNo }</span>
				<span class='id'>${vo.id }</span>
				<span class='name'>${vo.name }</span>
				<span class='gender'>${vo.gender }</span>
				<span class='phone'>${vo.phone }</span>
				<span class='mdate'>${vo.mdate }</span>
			</div>
		</c:forEach>
	</div>
	<div class='btn_zone' style='border-top: 2px solid #1b2035;'>
		<c:if test="${pVo.startPage>1 }">
			<input type='button' value='처음' class='btnFirst' onclick='move(1)'/>
			<input type='button' value='이전' class='btnPrev' onclick='move(${pVo.startPage-1})'/>
		</c:if>
		
		<c:forEach var='i' begin='${pVo.startPage }' end='${pVo.endPage }'>
			<input type='button' value='${i }' class='btnMove' onclick='move(${i})'/>
		</c:forEach>
		
		<c:if test="${pVo.totPage > pVo.endPage }">
			<input type='button' value='다음' class='btnNext' onclick='move(${pVo.endPage+1})'/>
			<input type='button' value='맨끝' class='btnLast' onclick='move(${pVo.totPage})'/>
		</c:if>
		
	</div>
	

</div>
</body>
</html>