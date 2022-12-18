<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer.jsp</title>
<script src ='../lib/jquery-3.6.1.min.js'></script>
<style>
.row:hover{
	background-color:#ccc;
}
</style>
</head>
<body>
<h3>고객 검색</h3>
<form name='frm' method='post'>
	<input type='text' name='findStr' id='findStr' class='findStr'/>
	<input type='button' name='search' class='search' value='검색'/>
</form>
<div id='customerResult'></div>
<script>
$('form>.search').on('click',function(){
	var param = "findStr=" + $('#findStr').val();
	$.post('customer_result.jsp',param,function(data){
		var rst='<div>';
		for(d of data){
			var temp = `
				<div class='row'>
					<span>\${d.customernumber}</span>
					<span>\${d.customername}</span>
					<span>\${d.phone}</span>
					<span>\${d.addressLine1}</span>
				</div>
			`;
			rst += temp;
		}
		rst += '</div>';
		$('#customerResult').html(rst);
		$('.row').css('display','table-row');
		$('.row>span').css({
			'display' : 'table-cell',
			'padding' : '0 10px'
		})
	},'json')
})
</script>
</body>
</html>