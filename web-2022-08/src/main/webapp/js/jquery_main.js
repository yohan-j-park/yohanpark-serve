/**
 * 
 */
$('main>*').css('box-sizing','border-box');

$('main').css({
	'border' : '3px solid #bbb',
	'width' : '1000px',
	'min-height' : '500px',
	'box-shadow' : '3px 3px 5px #999',
	'margin' : '20px auto',
	'position' : 'relative'
})
$('header, footer').css({
	'padding' : '20px',
	'background-color' : '#ddd'
})
$('header').css('position','relative')
$('nav').css({
	'position' : 'absolute',
	'bottom' : '5px',
	'right' : '5px'
})
$('footer').css({
	'position' : 'absolute',
	'bottom' : '0',
	'width' : '100%'
})
$('div#content').css({
	'color' : '#00f',
	'margin' : '20px',
	'border' : '2px solid #000',
	'max-height' : '300px',
	'overflow-y' : 'auto',
	'padding' : '20px'	
})
$('div#content>h2').css({
	'padding' : 0,
	'margin' : 0
})
// ajax 사용
var $c = $('div#content');
$('input#btnLoad').on('click',function(){
	$c.load('load.jsp');	
})
$('input#btnMain').on('click',function(){
	$('body').load('jquery_main.jsp');
})
$('input#btnGugudan').on('click',function(){
	$c.load('gugudan.jsp');
})
$('nav>#btnGET').on('click',function(){
	$c.load('get.jsp');
})
$('nav>#btnPOST').on('click',function(){
	$c.load('post.jsp');
})
$('nav>#btnCustomer').on('click',function(){
	$c.load('customer.jsp');
})
$('nav>#btnAjax').on('click',function(){
	$c.load('ajax.jsp');
})
$('nav>#btnSerialize').on('click',function(){
	$c.load('serialize.jsp');
})
$('nav>#btnMultipart').on('click',function(){
	$c.load('multipart_form.jsp');
})