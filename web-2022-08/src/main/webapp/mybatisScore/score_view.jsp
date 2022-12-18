<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis/score_view.jsp</title>
<script defer src='../mybatisScore/score.js'></script>
</head>
<body>
<div id='score'>
	<h2>성적관리</h2>
	<form name='frm' class='frm' method='post'>
		<label>아이디</label>
		<input type='text' name='id' value='${bVo.id }' readonly/><br/>
		<label>시험일</label>
		<input type='date' name='mdate' value='${bVo.mdate }' readonly/><br/>
		<label>과 목</label>
		<input type='text' name='subject'  value='${bVo.subject }' readonly/><br/>
		<label>점 수</label>
		<input type='text' name='score' value='${bVo.score }' readonly/><br/>
		<input type='button' value='수정' class='btnUpdate'/>
		<input type='button' value='삭제' class='btnDeleteR'/>
		<input type='button' value='취소' class='btnSelect'/>
		
		<input type='hidden' name='findStr' value="${pVo.findStr }"/>	<!-- 나중에 히든으로 바꾸기 -->
		<input type='hidden' name='nowPage' value='${pVo.nowPage }'/>	<!-- 나중에 히든으로 바꾸기 -->
	</form>
</div>
</body>
</html>