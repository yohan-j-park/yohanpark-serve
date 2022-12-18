<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis/member_update.jsp</title>
<script defer src='member.js'></script>
<style>
#photo{
	width:100px;
	height:150px;
	border:2px solid #aaa;
	border-radius:7px;
	margin:0;
	padding:0;
}
#rightphoto{
	display:inline-block;
	padding:0;
	margin:0;
}
#leftinfo{
	display:inline-block;
}
</style>
</head>
<body>
<div id='member'>
	<h2>회원관리</h2>
	<form name='frm' class='frm' method='post' enctype='multipart/form-data'>
		
		<div id='leftinfo'>
			<label>아이디</label>
			<input type='text' name='id' value='${bVo.id }'/><br/>
			<label>성 명</label>
			<input type='text' name='name' value='${bVo.name }'/><br/>
			<label>성별</label>
			<label><input type='radio' name='gender' value='m'/>남자</label>
			<label><input type='radio' name='gender' value='f'/>여자</label>
			<br/>
			<label>연락처</label>
			<input type='text' name='phone' value='${bVo.phone }'/><br/>
			<label>가입일</label>
			<input type='date' name='mdate' value="${bVo.mdate }"/><br/>
			<label>프로필 사진</label>
			<input type='file' name='att' id='photo_file' onchange='preview()' style="display:none"/><br/>	
			<input type='button' value='수정' class='btnUpdateR'/>
			<input type='button' value='취소' class='btnSelect'/>
			<input type='hidden' name='delFile' value="${bVo.sysFile }"/>	
			<input type='hidden' name='nowPage' value="${pVo.nowPage }"/>
			<input type='hidden' name='findStr' value="${pVo.findStr }"/>
		</div>	
		<div id="rightphoto">
			<img src='../upload/${bVo.sysFile }' id='photo' name='img' class='img'/>		
		</div>
	</form>
</div>
<script>
var gender = '${bVo.gender}';
var frm = $('.frm')[0];
if(gender=='m') frm.gender[0].checked=true;
else			frm.gender[1].checked=true;

var btnFile = document.querySelector('#photo_file');
var photo = document.querySelector('#photo');

photo.onclick = function(){
	btnFile.click();
}
function preview(ev){
	let event = ev || window.event;
	let file = event.srcElement.files[0];
	let reader = new FileReader();
	reader.onload = function(){
		let pre_img = photo
		let img = new Image();
		img.src = reader.result;
		pre_img.src = img.src;
	}
	reader.readAsDataURL(file);
}
</script>
</body>
</html>