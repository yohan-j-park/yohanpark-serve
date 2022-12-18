<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/serialize.jsp</title>
</head>
<body>
<h2>serialize</h2>
<form id='frm'>
	<label>성명</label>
	<input type='text' name='name' value='춘향이'/><br/>			
</form>
<form id='frm'>
	<label>성별</label>
	<label><input type='radio' name='gender' value='m' checked>남자</label>
	<label><input type='radio' name='gender' value='f'>여자</label>
	<br/>
	<label>취미</label>
	<label><input type='checkbox' name='hobby' value='승마' checked>승마</label>
	<label><input type='checkbox' name='hobby' value='양궁'>양궁</label>
	<label><input type='checkbox' name='hobby' value='육상' checked>육상</label>
	<label><input type='checkbox' name='hobby' value='검도'>검도</label>
	<br/>
	<input type='button' value='전송' id='btn'/>
</form>
<fieldset>
	<legend>Serialize Result</legend>
	<div id='result'></div>
</fieldset>

<script>
$('#btn').on('click',function(){
	//1) form 태그에 있는 항목들을 모두 serialize()를 사용하여 파라미터 작성
	var param = $('#frm').serialize();
	console.log(param);
	$.get('serialize_result.jsp',param,function(data){
		var str=`
			<ul>
				<li>name 	: \${data.name} </li>
				<li>gender  : \${data.gender} </li>
				<li>hobby   : \${data.hobby} </li>
				<li>msg 	: \${data.msg} </li>
			</ul>
		`;
		$('#result').html(str);
	},'json')
})
</script>
</body>
</html>