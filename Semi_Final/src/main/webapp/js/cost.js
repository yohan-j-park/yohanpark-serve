/**
 * 
 */
 
 

function view(pr_name){
	frmSearch.action = 'cost.do?job=update&pr_name='+pr_name;
	frmSearch.submit();
}

//수정

var btnModify = document.querySelector('#btnModify');
if(btnModify != null){
	btnModify.onclick = function(){
		var frm = document.frm_cost_modify;
		frm.action = 'cost_result.jsp?job=updateR';	
		frm.submit();
	}
}
		

//목록
var btnList = document.querySelector('#btnList');
if(btnList != null){
	btnList.onclick = function(){
		var frm = document.frm_cost_modify;
		frm.action = 'cost.do?job=select';
		frm.submit();
	}
}
	
