<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis/member_view.jsp</title>
<script defer src='member.js'></script>

</head>
<body>
<div id='member'>
	<h2>회원관리</h2>
	<form name='frm' class='frm' method='post'>
		<label>아이디</label>
		<input type='text' name='id' value='${bVo.id }' readonly/><br/>
		<label>성 명</label>
		<input type='text' name='name' value='${bVo.name }' readonly/><br/>
		<label>성별</label>
		<label><input type='radio' name='gender' value='m' readonly/>남자</label>
		<label><input type='radio' name='gender' value='f' readonly/>여자</label>
		<br/>
		<label>연락처</label>
		<input type='text' name='phone' value='${bVo.phone }' readonly/><br/>
		<label>가입일</label>
		<input type='date' name='mdate' value="${bVo.mdate }" readonly/><br/>
		<label>프로필 사진</label>
		<img src='../upload/${bVo.sysFile }' style='width:200px; height:100px;'/><br/>
		<input type='button' value='수정' class='btnUpdate'/>
		<input type='button' value='삭제' class='btnDeleteR'/>
		<input type='button' value='취소' class='btnSelect'/>
		
		<input type='hidden' name='findStr' value='${pVo.findStr }' readonly/>
		<input type='hidden' name='nowPage' value='${pVo.nowPage }' readonly/>
		<input type='hidden' name='delFile' value='${bVo.sysFile }' readonly/>
	</form>
</div>

<script>
var gender = '${bVo.gender}';
var frm = $('.frm')[0];
if(gender=='m') frm.gender[0].checked=true;
else			frm.gender[1].checked=true;
</script>
</body>
</html>