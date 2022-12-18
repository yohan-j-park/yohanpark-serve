/**
 * main.js
 */
$('#btnHome').on('click',function(){
	$('section').load('main_section.jsp');
})

$('#btnMember').on('click',function(){
	$('section').load('mms.do');
})

$('#btnScore').on('click',function(){
	$('section').load('../mybatisScore/scoreServlet.do');
})
$('img').on('click',function(){
	$('section').load('main_section.jsp');
})
