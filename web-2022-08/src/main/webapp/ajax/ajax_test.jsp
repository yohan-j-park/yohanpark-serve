<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax/ajax_test.jsp</title>
<style>
#output>div{
	display:inline-block;
	width:350px;
	padding:20px;
	box-sizing:border-box;
	min-height:250px;
	border:3px solid #aaa;
	vertical-align:top;
	margin-bottom:5px;
}
#output>#student{
	min-width:705px;
	max-width:1442px;
}
#output>#employee{
	min-width:705px;
	max-width:1442px;
}
#output>#append1{
	min-width:705px;
	max-width:1442px;
	text-align:center;
}
#output>#append2{
	min-width:705px;
	max-width:1442px;
	text-align:center;
}
#append2>div{
	width:180px;
	height:180px;
	display:inline-block;
	border:4px solid #6397be;
	box-shadow:3px 3px 4px #ccc;
	border-radius:8px;
	background-color:#bad1e9;
	margin:5px;
	padding:0;
}
</style>
<script defer src='ajax_test.js'></script>
</head>
<body>
<h2>Ajax Test</h2>
<input type='button' value='Load Text File' id='btnLoadText'/>
<input type='button' value='Load Html File' id='btnLoadHtml'/>
<input type='button' value='Load JSP File' id='btnLoadJSP'/>
<input type='button' value='Load Json File' id='btnLoadJson'/>
<input type='button' value='학생정보 조회' id='btnStudent'/>
<input type='button' value='직원정보 조회' id='btnEmployee'/>

<input type='button' value='Append 1' id ='btnAppend1'/>
<input type='button' value='Append 2' id ='btnAppend2'/>

<hr/>
<div id='output'>
	<div id='text'></div>
	<div id='html'></div>
	<div id='jsp'></div>
	<div id='json'></div>
	<div id='student'>
		<div id='frm'></div>
		<div id='list'></div>
	</div>
	<div id='employee'>
		<div id='frm_employee'></div>
		<div id='employee_list'></div>
	</div>
	<div id='append1'>
		<div>
			<input type='button' id='btnInsert' value='추가'/>
			<input type='button' id='btnDelete' value='삭제'/>
		</div>
		<div id='appendZone'>
		
		</div>
	</div>
	<div id='append2'>
		<div class='region'>
			<span>지역</span><br/>
			<select id='city'>
				<option value='서울'>서울</option>
				<option value='부산'>부산</option>
				<option value='대구'>대구</option>
			</select>
		</div>
		<div class='theater'>
			<span>상영관</span><br/>
			<select id='theater'>
			
			</select>
		</div>
		<div class='movietitle'>
			<span>영화제목</span><br/>
			<select id='movie'>
			
			</select>
		</div>
	</div>
</div>
</body>
</html>