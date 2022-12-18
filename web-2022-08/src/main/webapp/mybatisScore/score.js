/**
 *	score.js 
 */
$('.btnInsert').on('click',function(){
	var param = $('.frm').serialize();
	$.post('../mybatisScore/scorebean.jsp?job=insert',param, function(data){
		$('section').html(data);	
	})
})	

$('.btnInsertR').on('click',function(){
	var param = $('.frm').serialize();
	$.post('../mybatisScore/scorebean.jsp?job=insertR',param, function(data){
		$('section').html(data);	
	})
})



$('.btnSelect').on('click',function(){
	/*var frm = $('.frm')[0];*/
	var param = $('.frm').serialize();
	$.post('../mybatisScore/scorebean.jsp?job=select',param,function(data){
		$('section').html(data);
	})	
})


$('.btnSearch').on('click',function(){
	var frm = $('.frm')[0];
	frm.nowPage.value=1;
	
	var param = $(frm).serialize();
	$.post('../mybatisScore/scorebean.jsp?job=select',param,function(data){
		$('section').html(data);
	})	
})

$('.btnUpdate').on('click',function(){
	var param = $('.frm').serialize();
	$.post('../mybatisScore/scorebean.jsp?job=update',param, function(data){
		$('section').html(data);
	})
})	

$('.btnUpdateR').on('click',function(){
	var param = $('.frm').serialize();
	$.post('../mybatisScore/scorebean.jsp?job=updateR',param, function(data){
		$('section').html(data);	
	})
})

$('.btnDeleteR').on('click',function(){
	var yn = confirm('정말 삭제하시겠습니까?');
	if(!yn) return;
	var param = $('.frm').serialize();
	$.post('../mybatisScore/scorebean.jsp?job=delete',param, function(data){
		$('section').html(data);	
	})
})	



view=function(id){
	var frm = $('.frm')[0];
	frm.id.value=id;
	var param = $(frm).serialize();
	$.post('../mybatisScore/scorebean.jsp?job=view',param,function(data){
		$('section').html(data);
	})
}

move = function(nowPage){
	var frm = $('.frm')[0];
	frm.nowPage.value=nowPage;
	var param = $(frm).serialize();
	$.post('../mybatisScore/scorebean.jsp?job=select',param,function(data){
		$('section').html(data);
	})
}