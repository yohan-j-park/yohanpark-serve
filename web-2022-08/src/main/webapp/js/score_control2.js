/**
 * 성적관리 CRUD
 * 작성일 : 2022.08.30(yh)
 */

let m_index; // 배열의 위치값을 모든 function에서 사용하기 위해
let data=[
	{'stdid' : 201424042, 'subject' : '국어', 'grade' : 80},
	{'stdid' : 201324022, 'subject' : '영어', 'grade' : 70},
	{'stdid' : 201024038, 'subject' : '수학', 'grade' : 60},
	{'stdid' : 201524042, 'subject' : '과학', 'grade' : 90}
];
let template;
list();

function list(){
	let tot = 0; //평균을 구하기 위한 score합계.
	let items = document.querySelector('#items');
	items.innerHTML = '';
	for (index in data){
		v = data[index];
	template =
	`
	<div class='item' onclick='view("${index}")'>
		<span class='stdid'>${v.stdid}</span>
		<span class='subject'>${v.subject}</span>
		<span class='grade'>${v.grade}</span>
	</div>
	`
	items.innerHTML += template;
	tot += Number(v.score);
	}
}
function view(index){
	m_index = index;
	let frm = document.frm_member;
	frm.stdid.value = data[index].stdid;
	frm.subject.value = data[index].subject;
	frm.grade.value = data[index].grade; 
}


// 데이터 추가
function input(frm){
	let item = document.querySelector('#items');
	let status = document.querySelector('.status');	
	let index;
	let v;
	
//학번 입력 여부 체크
	if(frm.subject.value ==''){
		status.innerHTML = ('과목을 확인해 주세요');
		frm.subject.focus();
		return;
	} 
//성적 입력 여부 체크
	if(frm.grade.value=='' || isNaN(frm.grade.value)){
		status.innerHTML = ('성적을 확인해 주세요');
		frm.score.focus();
		return;
	};
//form 값을 {}로 만들어 data에 push
	v ={'stdid' : frm.stdid.value, 'subject':frm.subject.value,
		'grade' : frm.grade.value };
		
	data.push(v);//배열 뒤에 추가
	
	list();
}	

function update(frm){
	let index = m_index;
			if(index>=0){ //수정 할 데이터가 있는 경우
			data[index].subject = frm.subject.value;
			data[index].grade = frm.grade.value;
			data[index].stdid = frm.stdid.value;
			list();		
		}			
}
function deleteFunc(frm){
	let index = m_index;
	let status = document.querySelector('.status');
	if(index>=0){
		data.splice(index,1);
		list();
		frm.stdid.value='';
		frm.subject.value='';
		frm.grade.value='';
	}
}	
