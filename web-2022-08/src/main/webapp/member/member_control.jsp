<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_control.jsp</title>
<link rel='stylesheet' href='./css/member_control.css'>
<script defer src='./js/member_control2.js'></script>
</head>
<body>
<main id=member_main>
	<div class='main_title'>
	회원 정보 CRUD(Create 생성,추가 / Read 조회,읽기 / Update 수정 / Delete 삭제)
	</div>
	<form name='frm_member' enctype='multipart/form-data' method='post'>
		<div id="leftphoto">
		<img src='' id='photo' name='img' class='img'/>		
		</div>
		<div id='rightinfo'>
		<span>아이디</span>
		<input type='text' name='id' value='a001'/><br/>
		<span>성명</span>
		<input type='text' name='name' value='hong'/><br/>
		<span>성별</span>
		<label><input type='radio' name='gender' value='m'/>남자</label>
		<label><input type='radio' name='gender' value='f'/>여자</label><br/>
		<span>연락처</span>
		<input type='text' name='phone' value='010-1111-2222'/>
		<hr/>
		<span></span>
		<input type='button' value='CREATE' name='btnAppend' onclick='add(this.form)'/>
		<input type='button' value='UPDATE' name='btnUpdate' onclick='update(this.form)'/>
		<input type='button' value='DELETE' name='btnDelete' onclick='deleteFunc(this.form)'/>
		</div>
		<input type='file' id='photo_file' onchange='preview()' name='sysFile'/>
		<input type='text' name='delFile'/>
		
	</form>
	<div id='list'>
		<form name='frmSearch' method='post'>
			<input type='text' size='30' name='findStr'/>
			<input type='button' value='검색' name='btnFind'/>
		</form> 
		<div id='title'>
			<span class='id'>아이디</span>
			<span class='name'>성명</span>
			<span class='gender'>성별</span>
			<span class='phone'>연락처</span>
		</div>
		<div id='items'>	<!-- 배열에 저장 -->
			<div class='item'>
				<span class='id'>a001</span>
				<span class='name'>홍길동</span>
				<span class='gender'>m</span>
				<span class='phone'>010-1111-2222</span>
			</div>		
		</div> 	
	</div>
</main>
</body>
</html>