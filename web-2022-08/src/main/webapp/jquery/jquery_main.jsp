<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/jquery_main.jsp</title>
<script src ='../lib/jquery-3.6.1.min.js'></script>
<script defer src='../js/jquery_main.js'></script>
<!-- <script src="https://code.jquery.com/jquery-3.6.1.js"></script>  -->
<link rel='icon' href='../images/농담곰.jpg'/>
</head>
<body>
<main>
	<header>header
		<nav>
			<input type='button' id='btnMain' 		value='초기화면으로'/>
			<input type='button' id='btnLoad' 		value='load.jsp 불러오기'/>
			<input type='button' id='btnGugudan' 	value='구구단 불러오기'/>
			<input type='button' id='btnGET' 		value='GET'/>
			<input type='button' id='btnPOST' 		value='POST'/>
			<input type='button' id='btnCustomer'   value='고객검색'/>
			<input type='button' id='btnAjax'		value='ajax'/>
			<input type='button' id='btnSerialize'  value='serialize'/>
			<input type='button' id='btnMultipart'  value='multipart'/>
		</nav>	
	</header>
	<div id='content'>jQuery Example</div>
	<footer>footer</footer>
</main>
</body>
</html>