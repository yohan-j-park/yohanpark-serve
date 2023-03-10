/**
 * 학생관리 CRUD
 * 작성일 : 2022.08(yh)
 */

let data = [
	{'id' : 'a001', 'name' : 'hong', 'gender' : 'm', 'phone' : '010-1111-1111'},
	{'id' : 'b001', 'name' : 'kim' , 'gender' : 'f', 'phone' : '010-2222-2222'},
	{'id' : 'c001', 'name' : 'lee' , 'gender' : 'f', 'phone' : '010-3333-3333'}
]; 	// []=newArray()
let frm=document.frm_member;
let frmSearch = document.frmSearch;
let template;
list();
frmSearch.btnFind.onclick = list;
function list(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	
	var xhr = new XMLHttpRequest();
	xhr.open('post','memberServlet.do?findStr='+frmSearch.findStr.value);
	xhr.send();
	xhr.onreadystatechange=function(){
		if(xhr.status==200 && xhr.readyState==4){
			var data = JSON.parse(xhr.responseText);
			for (v of data){
				template =
					`
					<div class='item' onclick='view("${v.id}")'>
						<span class='id'>${v.id}</span>
						<span class='name'>${v.name}</span>
						<span class='gender'>${v.gender}</span>
						<span class='phone'>${v.phone}</span>
					</div>
					`
				items.innerHTML +=(template);
			}
		}	
	}
	
}
function view(id){
	let img = document.querySelector('.img');
	
	var xhr = new XMLHttpRequest();
	xhr.open('post','memberServlet.do?job=view&id='+id);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			var obj = JSON.parse(xhr.responseText);
			
			frm.reset();
			
			frm.id.value = obj.id;    
			frm.name.value = obj.name;
			frm.phone.value = obj.phone;
			if(obj.gender=='m'){
				frm.gender[0].checked=true;
			}else{
				frm.gender[1].checked=true;
			}
		img.src='./upload/' + obj.sysFile;		
		frm.delFile.value = obj.sysFile;
		}
	}
	
	
}


//데이터 추가
function add(frm){
	let gender;
	let v;	
	let items = document.querySelector('#items');
	let index;
	// id 중복 체크 type1
	index = data.findIndex(d=>d.id==frm.id.value); 
	if(index>=0){
		alert('아이디가 중복되었습니다.');
		frm.id.focus();
		return;
	}
	// id 중복 체크 type2
/*	index = data.findIndex(function(v, index){
		let r= -1;
		if(v.id == frm.id.value) r=index;
		if(index>=0){
		alert('아이디가 중복되었습니다.');
		frm.id.focus();
		return r;
		
	});
*/
	
	
	// 성별 체크 유무
	if(!frm.gender[0].checked && !frm.gender[1].checked){
		alert('성별을 체크해 주세요');
		return;
	} // frm.gender[0]의 값이 체크되어있지 않고 frm.gender[1]의 값이 체크되어 있지 않으면..
	
	/*
	gender = data.findIndex(g=>g.gender==frm.gender.value);
	if(gender!=0 || 1)
		alert('성별을 선택해 주세요');
		return;
	*/
	
	//이름 입력 여부 체크
	if(frm.name.value==''){
		alert('성명을 입력해 주세요');
		frm.name.focus();
		return;
	}
	//연락처 입력 여부 체크
	if(frm.phone.value==''){
		alert('연락처를 확인해 주세요');
		frm.phone.focus();
		return;
	}	
	if(frm.gender[0].checked) gender=frm.gender[0].value;
	else gender = frm.gender[1].value;

	//enctype이 있는 form을 multipart 타입으로 변환
	var fd = new FormData(frm); 
	var xhr = new XMLHttpRequest();
	xhr.open('post', 'memberUpload.do?job=insert');
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			msg = xhr.responseText;
			alert(msg);
		}
	}
	xhr.send(fd);

}


function update(frm){
	let gender;
	let v;	
	let items = document.querySelector('#items');
	let index;
	// id 중복 체크 type1
	index = data.findIndex(d=>d.id==frm.id.value); 
	if(index>=0){
		alert('아이디가 중복되었습니다.');
		frm.id.focus();
		return;
	}
	
	// 성별 체크 유무
	if(!frm.gender[0].checked && !frm.gender[1].checked){
		alert('성별을 체크해 주세요');
		return;
	} // frm.gender[0]의 값이 체크되어있지 않고 frm.gender[1]의 값이 체크되어 있지 않으면..
	
	
	//이름 입력 여부 체크
	if(frm.name.value==''){
		alert('성명을 입력해 주세요');
		frm.name.focus();
		return;
	}
	//연락처 입력 여부 체크
	if(frm.phone.value==''){
		alert('연락처를 확인해 주세요');
		frm.phone.focus();
		return;
	}	
	if(frm.gender[0].checked) gender=frm.gender[0].value;
	else gender = frm.gender[1].value;

	//enctype이 있는 form을 multipart 타입으로 변환
	var fd = new FormData(frm); 
	var xhr = new XMLHttpRequest();
	xhr.open('post', 'memberUpload.do?job=update');
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			msg = xhr.responseText;
			alert(msg);
		}
	}
	xhr.send(fd);

}

function deleteFunc(frm){
	
	var yn = confirm("정말 삭제하시겠습니까?");
	if(!yn) return;
	
	var id = frm.id.value;
	var delFile = frm.delFile.value;
	var url =`memberServlet.do?job=delete&id=${id}&delFile=${delFile}`;
	var xhr = new XMLHttpRequest();
	xhr.open('post', url);
	xhr.send();
	xhr.onreadystatechange = function(){
		if(xhr.status==200 && xhr.readyState==4){
			var msg = xhr.responseText;
			alert(msg);
			document.frmSearch.btnFind.click();
		}
	}
}

let btnFile = document.querySelector('#photo_file');
let photo = document.querySelector('#photo');
photo.onclick = function(){
	btnFile.click();
}

function preview(ev){
	let event = ev || window.event;
	let file = event.srcElement.files[0];
	
	let reader = new FileReader();
	reader.onload = function(){
		let pre_img = photo
		let img = new Image();
		img.src = reader.result;
		pre_img.src = img.src;
	}
	reader.readAsDataURL(file);
}

/*
이미지 미리보기(강사님 code)
function preview(){
	frm.photo.click();
}
frm.photo.onchnage = function(ev){
	let img = document.querySelector('.img');
	let file = ev.srcElement.files[0];
	let reader = new FileReader();
	reader.readAsDataURL(file);
	reader.onload=function(fev){
		img.src = this.result;
	}
}
*/