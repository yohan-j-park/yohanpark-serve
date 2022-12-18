<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='../mybatisScore/score.css'>
<title>mybatisScore/score.jsp</title>
<script defer src='../mybatisScore/score.js'></script>

  
</head>
<body>
	<div id='score'>
		<h2>성적관리</h2>
		<form name='frm' method='post' class='frm'>
			<input type='button' value='입력' class='btnInsert'/>
			<input type='search' name='findStr' value="${pVo.findStr }" autocomplete='off'/>
			<input type='button' value='검색' class='btnSearch'/>
			<input type='hidden' name='nowPage' value='${pVo.nowPage }'/>	<!-- 나중에 히든으로 바꾸기 -->
			<input type='hidden' name='id'/>	<!-- 나중에 히든으로 바꾸기 -->
		</form>
		<br/>
		<div class='title' style='background-color:#1b2035;'>
			<span class='no'>NO</span>
			<span class='serial'>SERIAL</span>
			<span class='id'>학 번</span>
			<span class='subject'>과 목</span>
			<span class='mdate'>시험일자</span>
			<span class='score'>성 적</span>
		</div>
		<div class='items'>
		<c:set var="no" value="0"/>
		<c:forEach var='vo' items="${list }" varStatus="status">
			<div class='item' onclick="view('${vo.id}')">
				<span class='no'>${status.count + pVo.startNo }</span>
				<span class='serial'>${vo.serial }</span>
				<span class='id'>${vo.id }</span>
				<span class='subject'>${vo.subject }</span>
				<span class='mdate'>${vo.mdate }</span>
				<span class='score'>${vo.score }</span>
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