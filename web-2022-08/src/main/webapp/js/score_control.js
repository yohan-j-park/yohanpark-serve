/**
 * 성적관리 CRUD
 * 작성일 : 2022.08.30(yh)
 */
/*
let data=[
	{'stdid' : 201424042, 'subject' : '국어', 'grade' : 80},
	{'stdid' : 201324022, 'subject' : '영어', 'grade' : 70},
	{'stdid' : 201024038, 'subject' : '수학', 'grade' : 60},
	{'stdid' : 201524042, 'subject' : '과학', 'grade' : 90}
]
let template;
list();
function list(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	for (v of data){
		
	template =
	`
	<div class='item' onclick='view("${v.stdid}")'>
		<span class='stdid'>${v.stdid}</span>
		<span class='subject'>${v.subject}</span>
		<span class='grade'>${v.grade}</span>
	</div>
	`
	items.innerHTML += template;
	}
}
function view(stdid){
	let index = data.findIndex(d=>d.stdid==stdid);
	let frm=document.frm_member;
	frm.stdid.value = data[index].stdid;
	frm.subject.value = data[index].subject;
	frm.grade.value = data[index].grade; 
}

// 데이터 추가
function input(frm){
	let item = document.querySelector('#items');
	let index;
	let v;
	v={'stdid':frm.stdid.value, 'subject':frm.subject.value,
	   'grade':frm.grade.value};

	data.push(v);
	
	template =
	`
	<div class='item' onclick='view("${v.stdid}")'>
		<span class='stdid'>${v.stdid}</span>
		<span class='subject'>${v.subject}</span>
		<span class='grade'>${v.grade}</span>
	</div>
	`
	items.innerHTML += template;
a();
}
function update(frm){
	let index = data.findIndex(d=>d.stdid==frm.stdid.value);
	if(index>=0){
		data[index].stdid = frm.stdid.value;
		data[index].subject = frm.subject.value;
		data[index].grade = frm.grade.value;
		list();
		alert('데이터가 수정되었습니다.');
	}else{
		alert('수정 할 데이터가 없습니다.');
	}
a();
}

function deleteFunc(frm){
	let index = data.findIndex(d=>d.stdid==frm.stdid.value);
	if(index>=0){
		data.splice(index,1);
		list();
		frm.stdid.value='';
		frm.subject.value='';
		frm.grade.value='';
	}else{
		alert('삭제 할 자료를 찾지 못했습니다.');
	
	}
a();
}
function a(){
	let sum = 0;
	
	for(i=0; i<data.length; i++){
		sum = sum+Number(data[i].grade);
		avg = (sum/data.length);
		avg2 = avg.toFixed(1);
	result.innerHTML = ('평 균:' +avg2);
	}
	
}
a();	
*/