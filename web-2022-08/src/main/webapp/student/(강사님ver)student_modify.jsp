<%@page import="student.StudentVo"%>
<%@page import="student.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
<link rel='stylesheet' href='./student/(강사님ver)student.css'>
<script defer src='//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js'></script>
<script defer src='js/student.js'></script>
</head>
<body>
<jsp:useBean id ="pageVo" class="student.Page"/>
<jsp:setProperty property="*" name="pageVo"/>

<jsp:useBean id="studentVo" class="student.StudentVo"/>
<jsp:setProperty property="*" name="studentVo"/>

<%
	StudentDao dao = new StudentDao();
	StudentVo vo = dao.view(studentVo.getId());
%>

<div id='std_modify'>
	<h2>학생정보 수정</h2>
	<form name='frm_student' method='post'>
		<span>아이디</span>
		<input type='search' name='id' value='<%=vo.getId() %>' size='10' maxlength='20' required
		   autocomplete='off'/>
	<br/>
		<span>성 명</span>
		<input type='search' name='name' value='<%=vo.getName() %>' size='7' maxlength='5' required
		   autocomplete='off'/>
	<br/>
		<span>성 별</span>
		<label><input type='radio' name='gender' value='m'>남자</label>
		<label><input type='radio' name='gender' value='f'>여자</label> 
	<br/>
		<span>암 호</span>
		<input type='password' name='pwd'/>
	<br/>
		<span>암호확인</span>
		<input type='password' name='pwd2'/>
	<br/>		
		<span>연락처</span>
		<input type='search' name='phone' value='<%=vo.getPhone() %>' size='20'  maxlength='20' required
		   autocomplete='off'/>
	<br/>
		<span>우편번호</span>
		<input type='text' name='zipcode' value='<%=vo.getZipcode() %>' size='5' required readonly/>
		<input type='button' name='btnFindZip' value='우편번호 검색'/>
	<br/>
		<span>주 소</span>
		<input type='text' name='address' value='<%=vo.getAddress() %>' size='40' required/>
	<br/>
		<span>상세주소</span>
		<input type='text' name='address2' value='<%=vo.getAddress2() %>' size='40'/>
	<br/>
		<span>이메일</span>
		<input type='search' name='email' value='<%=vo.getEmail()%>'/>
	<br/>
		<div class='btnzone'>
			<span></span>
			<input type='button' value='수정' id='btnModify'/>
			<input type='button' value='삭제' id='btnDelete'/>
			<input type='button' value='목록' id='btnSelect'/>
	
		</div>
	<input type='text' name='findStr' value='<%=pageVo.getFindStr()%>'/>
	<input type='text' name='nowPage' value='<%=pageVo.getNowPage()%>'/>
	</form>
</div>
<script>
var frm = document.frm_student;
frm.btnFindZip.onclick = function(){
	new daum.Postcode({
		oncomplete : function(data){
			frm.address.value = data.address;
			frm.zipcode.value = data.zonecode;
		}
	}).open(); //daum에서 제공해주는 우편번호 api를 여는 코드
}

checkGender('<%=vo.getGender()%>');
function checkGender(g){
   var frm = document.frm_student;
   if(g=='m') frm.gender[0].checked=true;
   else frm.gender[1].checked=true;
}   
</script>
</body>
</html>