/**
 * 성명, 아이디, 연락처, 이메일이 아래와 같은 배열에 저장되어 있을 때 이를 사용하여 화면에 목록 형식으로 출력하는 코드를 작성하고, html, js, css 파일, 출력 결과 이미지 작성하시오.
array = [
{ 'name': 'hong1', 'id' : 'a001', 'phone' : '1234' , 'email' : 'a001@abc.kr'},
{ 'name': 'hong2', 'id' : 'a002', 'phone' : '1235', 'email' : 'a002@abc.kr'},
{ 'name': 'hong3', 'id' : 'a003', 'phone' : '1236', 'email' : 'a003@abc.kr'},
{ 'name': 'hong4', 'id' : 'a004', 'phone' : '1237', 'email' : 'a004@abc.kr'},
]
[출력 결과]
----------------------------------------------------------
성명    아이디        연락처       이메일
----------------------------------------------------------
 */

let array = [
{ 'name': 'hong1', 'id' : 'a001', 'phone' : '1234', 'email' : 'a001@abc.kr'},
{ 'name': 'hong2', 'id' : 'a002', 'phone' : '1235', 'email' : 'a002@abc.kr'},
{ 'name': 'hong3', 'id' : 'a003', 'phone' : '1236', 'email' : 'a003@abc.kr'},
{ 'name': 'hong4', 'id' : 'a004', 'phone' : '1237', 'email' : 'a004@abc.kr'},
];

let template;
list();
function list(){
	let items = document.querySelector('#items');
	items.innerHTML = '';
	for (v of array){
		template = 
		`
		<div id='items'>	
			<div class='item'>
				<span class='name'>${v.name}</span>
				<span class='id'>${v.id}</span>
				<span class='phone'>${v.phone}</span>
				<span class='email'>${v.email}</span>
			</div>
		`
		items.innerHTML += template;
	}
}
