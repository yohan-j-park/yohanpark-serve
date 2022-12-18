/**
 *       서블릿을 호출하도록 다 만들었다 !!
 */

 /* 저장버튼 처리 */
 var frmInput = document.frm_input;
 if(frmInput != null){
   function btnCancel(){
	frmInput.action = 'operation.do?job=select';
    frmInput.submit();
	}
  
   //Servlet을 직접 호출하지 않고, useBean으롤 객체 만든후
   //Servlet을 호출하는 result.jsp 호출
   function btnSave(){
      frmInput.action = 'result.jsp?job=insertR';
      frmInput.submit();
   }
}

 /* 조회 화면 처리 => 두번째 기능이 매우 중요합니다. */
 var frmSearch = document.frm_search;
 if(frmSearch != null){
   function btnInsert(){      
      frmSearch.action = 'operation.do?job=insert';
      frmSearch.submit();
   };
   
   function btnSearch(){      
      frmSearch.action = 'operation.do?job=select';      
      frmSearch.nowPage.value=1;
      frmSearch.submit();
   }
      
   function btnStat(){
      frmSearch.action = 'operation.do?job=stat';
      frmSearch.submit();
   }   
}

function movePage(nowPage){
   frmSearch.action = 'operation.do?job=select';
   frmSearch.nowPage.value=nowPage;
   frmSearch.submit();   
}

function view(pr_code){
   frmSearch.action = 'operation.do?job=update&pr_code='+pr_code;
   frmSearch.submit();
}


/* 상세보기, 수정, 삭제 ---------------------------------------- */
var btnSelect = document.querySelector('#btnSelect');
if(btnSelect != null){
   btnSelect.onclick = function(){
      var frm = document.frm_operation;
      frm.action = 'operation.do?job=select';
      frm.submit();
   }
}



/* 수정----- */
var btnModify = document.querySelector('#btnModify');
if(btnModify != null){
   btnModify.onclick = function(){
      var frm = document.frm_operation;
      frm.action = 'result.jsp?job=updateR';   //R:result
      frm.submit();
   }
}

var btnDelete = document.querySelector('#btnDelete');
if(btnDelete != null){
   btnDelete.onclick = function(){
      var frm = document.frm_operation;
      frm.action = 'result.jsp?job=deleteR';
      frm.submit();
   }
}


function btnBack(){
   var frm = document.frmStat;
   frm.action = 'operation.do?job=select';
   frm.submit();
}








