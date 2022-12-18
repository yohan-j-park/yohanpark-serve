<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery/load.jsp</title>
<script src ='../lib/jquery-3.6.1.min.js'></script>
</head>
<body>
<div id='load'>
	<input type='button' value='페이지 전체 읽기' id='btnFull'/>
	<input type='button' value='part1만 읽기' id='btnPart1'/>
	<input type='button' value='part2만 읽기' id='btnPart2' style='margin-bottom:5px;'/>
	<div class='result'></div>
</div>

<script>
	var $r =  $('#load>.result');
	$($r).css({
		'padding' : '20px',
		'background-color' : '#ddd',
		'min-height' : '50px'
	})
	
	$('#load>#btnFull').on('click',function(){
		$r.load('load_test.jsp');
	})
	
	$('#load>#btnPart1').on('click',function(){
		$r.load('load_test.jsp #part1');
	})
	
	$('#load>#btnPart2').on('click',function(){
		$r.load('load_test.jsp #part2');
	})
</script>
</body>
</html>