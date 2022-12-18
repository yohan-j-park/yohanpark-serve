<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(강사님ver)학생정보 입력</title>
<link rel='stylesheet' href='./student/(강사님ver)student.css'>
<script src='//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js'></script>
<script defer src='js/student.js'></script>

</head>
<body>
<jsp:useBean id = "pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<div id='std_input'>
	<h2>학생 정보 입력</h2>
	<form name='frm_input'	method='post' onsubmit='return chkForm(this)'>
		<span>*아이디</span>
		<input type='search' name='id' size='10' maxlength='20' required='required'
			   autocomplete='off'/>
	   <!-- 강사님 예시: 아이디 Pattern="^[a-zA-Z]\w{3,19}"  -->
		<input type='button' name='chk_id' value='중복 확인'/>
		<br/>
		<span>*성 명</span>
		<input type='search' name='name' size='7' maxlength='5' required
			   autocomplete='off'/>
		<br/>
		<span>성 별</span>
		<label><input type='radio' name='gender' value='m' checked>남자</label>
		<label><input type='radio' name='gender' value='f'>여자</label>
		<br/>
		<span>*암 호</span>
		<input type='password' name='pwd' size='15' maxlength='15' required/>
		<br/>
		<span>*암호 확인</span>
		<input type='password' name='pwd2' size='15' maxlength='15' required/>
		<br/>
		<span>*연락처</span>
		<input type='search' name='phone' size='20' maxlength='20' required
			   autocomplete='off'/>
		<br/>
		<span>*우편번호</span>
		<input type='text' name='zipcode' size='5' required readonly/>
		<input type='button' name='btnFindZip' value='우편번호 검색'/>
		<br/>
		<span>*주 소</span>
		<input type='text' name='address' size='40' autocomplete='off' required/>
		<br/>
		<span>상세주소</span>
		<input type='text' name='address2' size='30' autocomplete='off'/>
		<br/>
		<span>*이메일</span>
		<input type='email' name='email' autocomplete='off' required/>
		<!-- input type='email'하면 자동으로 email형식이 됨 -->
		
		<!-- <input type='button' name='chk_email' value='인증번호 발송'/>
		<br/>
		<span>인증번호</span>
		<input type='text' name='email2' size='6'/>
		 -->
		<div class='btnzone'>
			<span></span>
			<input type='submit' name='btnSave' value='저장'/>
			<input type='button' name='btnCancel' value='취소'/>
		</div>
		<input type='text' name='findStr' value='<%=pageVo.getFindStr()%>'/>
		<input type='text' name='nowPage' value='<%=pageVo.getNowPage()%>'/> 
	</form>



</div>
<script>
let frm = document.frm_input;
frm.btnFindZip.onclick = function(){
	new daum.Postcode({
		oncomplete : function(data){
			frm.address.value = data.address;
			frm.zipcode.value = data.zonecode;
		}
	}).open(); //daum에서 제공해주는 우편번호 api를 여는 코드
}

 //ID에 영,숫자만 입력

regid = /^[a-zA-Z]+[a-zA-Z0-9]$/;
function idCheck(){
	if(!regid.test(frm.id.value)){
		alert('아이디는 영어 및 숫자만 입력 가능합니다. (단, 영문으로 시작)');
	}else{alert('사용 가능한 아이디입니다.')};
}	
 /* frm.chk_id.addEventListener("click",idCheck); */

// 연락처 패턴에 맞게 입력
regphone = /^\d{2,3}-\d{3,4}-\d{4}$/;
function phoneCheck(){
	if(!regphone.test(frm.phone.value)){
		alert('유효한 휴대폰 번호를 입력해 주세요');
	}
}
/* frm.submit.addEventListener("click",phoneCheck); */ 

// 이메일 패턴에 맞게 입력
regemail = /^\w{3,}@[a-z]{3,}(\.[a-z]{2,3}){1,2}$/;
function emailCheck(){
	if(!regemail.test(frm.email.value)){
		alert('유효한 이메일주소를 입력해 주세요');
	}else{alert('인증번호가 발송되었습니다.')};
}
/* frm.chk_email.addEventListener("click",emailCheck); */

// 암호와 암호확인의 값이 동일한지 체크
function pwdCheck(){
	if(frm.pwd.value != frm.pwd2.value){
		alert('암호가 일치하지 않습니다.')
	}
}
/* frm.submit.addEventListener("click",pwdCheck); */

/*
function chkForm(frm){
	let b=true;
	if(frm.pwd.value != frm.pwd2.value){
		b=false;
		alert('암호가 일치하지 않습니다.')
	}
	return b;
}
*/
</script>

</body>
</html>