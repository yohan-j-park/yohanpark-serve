<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student_modify.jsp</title>
<link rel='stylesheet' href='student.css'>
</head>
<body>
<h2>학생정보 수정</h2>
<span>아이디</span>
	<input type='text' name='id' maxlength='10'
	size='20'/>
<br/>	
<span>성명</span>
	<input type='text' name='name'maxlength='5'
	size='8'/>
<br/>	
<span>성별</span>
	<input type='radio' name='gender' value='m'/>남자
	<input type='radio' name='gender' value='f'/>여자
<br/>
<span>연락처</span>
	<input type='text' name='phone' maxlength='12'
	size='25'/>
<br/>
<span>우편번호</span>
	<input type='text' name='zip' maxlength='5' size='6'/>
	<input type='button' value='우편번호 검색'/>
<br/>
<span>주소</span>
	<input type='text' name='add' size='40'/>
<br/>
<span>이메일</span>
	<input type='text' size='30'/>	
<br/>
<br/>
<div class='button'><input type='button' value='수정'/>
<input type='button' value='삭제'/>
<input type='button' value='취소'/>
</div>		
</body>
</html>