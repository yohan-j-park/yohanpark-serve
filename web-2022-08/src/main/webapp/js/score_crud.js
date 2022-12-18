/**
 * 
 */
let list=[]; //전체 데이터 저장
let frm = document.frm;
//한 건의 데이터를 저장하기 위한 구조
function Score(serial, id, subject, score){
	this.serial = serial;
	this.id = id;
	this.subject = subject;
	this.score = score;
	this.output = function(){
		let str = `
			<div class='item' onclick='view("${this.serial}")'>
				<span class='serial'>${this.serial}</span>
				<span class='id'>${this.id}</span>
				<span class='subject'>${this.subject}</span>
				<span class='score'>${this.score}</span>
			</div>
		`;
		return str;
	}
}

// 저장 및 시리얼넘버 중복, 빈 칸 확인
frm.btnSave.onclick = function(){
	let serial = frm.serial.value;
	let id = frm.id.value;
	let subject = frm.subject.value;
	let score = frm.score.value;
	//let overlap = list.findIndex(r=>r.serial==serial);
	let overlap = list.findIndex(function(r){
		return r.serial==serial;
		
	});
	if(overlap>=0){
		alert('시리얼 넘버가 중복되었습니다.');
		frm.serial.foucs();
		return;
	}
	if(serial<=0 || serial%1 !=0 || serial==''){
		alert('시리얼값에 양의 정수 값을 입력해 주세요');
		frm.serial.focus();
		return;
	}
	if(id==''){
		alert('학번을 입력해 주세요');
		frm.id.focus();
		return;
	}
	if(subject==''){
		alert('과목을 입력해 주세요')
		frm.subject.focus();
		return;
	}
	if(score==''){
		alert('성적을 입력해 주세요')
		frm.score.focus();
		return;
	}
	let d = new Score(serial, id, subject, score);
	return list.push(d);
}
// 출력
frm.btnOutput.onclick = function(){
	let str='';
	let items = document.querySelector('.items');
	for(d in list){
		str += list[d].output();
	}
	items.innerHTML = str;
};

// 성적현황 리스트 클릭 시 성적관리CRUD로 데이터값 이동
function view(serial){
	/* let index = list.findIndex(d=>d.serial==serial);*/
	let index = list.findIndex(function(d){
		return d.serial==serial
	});
	frm.serial.value = list[index].serial;
	frm.id.value = list[index].id;
	frm.subject.value = list[index].subject;
	frm.score.value = list[index].score;
}

// 시리얼 검색
frm.findSerial.onclick = function(){
	let serial = frm.serial.value;
	for(d in list){
		if(list[d].serial == serial){
			frm.id.value = list[d].id;
			frm.subject.value = list[d].subject;
			frm.score.value = list[d].score;
		}
	}
}

// 수정
frm.btnUpdate.onclick = function(){	
	let index = list.findIndex(d=>d.serial==frm.serial.value);
	let serial = frm.serial.value;
	let id = frm.id.value;
	let subject = frm.subject.value;
	let score = frm.score.value;
	
	if(serial<=0 || serial%1 !=0 || serial==''){
		alert('시리얼값에 양의 정수 값을 입력해 주세요');
		frm.serial.focus();
		return;
	}
	if(id==''){
		alert('학번을 입력해 주세요');
		frm.id.focus();
		return;
	}
	if(subject==''){
		alert('과목을 입력해 주세요')
		frm.subject.focus();
		return;
	}
	if(score==''){
		alert('성적을 입력해 주세요')
		frm.score.focus();
		return;
	}
	if(index>=0){
		list[index].id = frm.id.value;
		list[index].subject = frm.subject.value;
		list[index].score = frm.score.value;
		list[index].serial = frm.serial.value;
		frm.btnOutput.click();
		alert('데이터가 수정되었습니다.');
	}else{
		alert('수정 할 데이터가 없습니다.');
	}
}

//삭제
frm.btnDelete.onclick = function(){
	let index = list.findIndex(d=>d.serial==frm.serial.value);
	if(index>=0){
		list.splice(index,1);
		
		frm.serial.value='';
		frm.id.value='';
		frm.subject.value='';
		frm.score.value='';
		frm.btnOutput.click();
		alert('데이터가 삭제되었습니다.')
	}else{
		alert('삭제 할 자료를 찾지 못했습니다.');
	}
}