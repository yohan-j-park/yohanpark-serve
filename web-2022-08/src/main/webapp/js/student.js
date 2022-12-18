/**
 * 학생관리
 */

/* 조회 화면 에서 입력 누르면 입력 화면 이동 처리 */
var frmSearch = document.frm_search;
if(frmSearch != null){
	frmSearch.btnInsert.addEventListener('click',function(){
		frmSearch.action='index.jsp?inc=student/(강사님ver)student_input_form.jsp';
		/* action 속성은 폼 데이터(form data)를 서버로 보낼 때 해당 데이터가 도착할 URL을 명시합니다. */
		frmSearch.submit();
	});
	
	frmSearch.btnSelect.onclick= function(){
		frmSearch.action = 'index.jsp?inc=student/(강사님ver)student_list.jsp';
		frmSearch.nowPage.value=1;
		frmSearch.submit();
	}
}
 
function movePage(nowPage){
		frmSearch.action = 'index.jsp?inc=student/(강사님ver)student_list.jsp';
		frmSearch.nowPage.value=nowPage;
		frmSearch.submit();
}

function view(id){
	frmSearch.action='index.jsp?inc=student/(강사님ver)student_modify.jsp&id=' + id; 
 	frmSearch.submit();
	// GetType으로 넘기는 방법(id값을 저장하는 코드를 추가할 일 없이 넘길 수 있음 / url에 나타나기 때문에 보안에 취약)	
	//frmSearch.action='index.jsp?inc=student/(강사님ver)student_modify.jsp';
	//frmSearch.id.value=id;  list에 name이 id인 input text를 만들어서 값을 넘기는 방법도 있다.
}

/* 입력 화면 처리---------------------------------------------------------------------------------- */
var frmInput = document.frm_input;

if(frmInput != null){

/* 입력 화면 Cancel 처리 */
	frmInput.btnCancel.addEventListener('click',function(){
		frmInput.action='index.jsp?inc=student/(강사님ver)student_list.jsp';
		frmInput.submit();
	});
/* 입력 화면 저장 처리 */
	frmInput.btnSave.onclick = function(){
		frmInput.action='index.jsp?inc=student/student_input_result.jsp';
		frmInput.submit();
	}	
}

/* 상세보기, 수정, 삭제----------------------------------------------------------------------------- */
var btnSelect = document.querySelector('#btnSelect');
if(btnSelect != null){
	btnSelect.onclick = function(){
		var frm = document.frm_student;
		frm.action = 'index.jsp?inc=student/(강사님ver)student_list.jsp';
		frm.submit();
	}
}


/* 수정-------------------------------------------------- */
var btnModify = document.querySelector("#btnModify");
if(btnModify != null){
	var frm = document.frm_student;
	btnModify.onclick = function(){		
	frm.action ='index.jsp?inc=student/student_modify_result.jsp';
	frm.submit();
	}
}


/* 삭제------------------------------------------------- */
var btnDelete = document.querySelector("#btnDelete");
if(btnDelete != null){
	var frm = document.frm_student;
	btnDelete.onclick = function(){		
	frm.action="index.jsp?inc=student/student_delete_result.jsp";
	frm.submit();
	}
}