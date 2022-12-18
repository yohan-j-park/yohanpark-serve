/*


import blocks from './blocks.js'
// DOM
let playground = document.querySelector(".playground > ul");
const gameText = document.querySelector(".game-text");
const scoreDisplay = document.querySelector(".score");
const restartButton = document.querySelector(".game-text > button");

// SETTING
let game_rows = 20;
let game_cols = 10;


// variables;
let score = 0;  
let duration = 500;		//블럭이 떨어지는 시간
let downInterval; 		//최대한 null값?
let tempMovingItem;		// 무빙을 실행하기 전에 담아두는 용도
let isFalling = false;

const MovingItem = {	// 다음 블럭의 타입과 좌표들의 정보를 담는 변수
	type: "",
	direction: 3, 		// 화살표 방향키를 눌렀을때 좌우로 돌리는 지표
	top: 0,				// 좌표 기준으로 어디까지 내려가야 되는지 표현해주는 것
	left: 3,		// 좌표 기준으로 어디까지 옆으로 움직일 수 있는지 표현해주는 것	
};

init()


// functions
function init(){     /* 화면이 처음 실행될 때 실행되는 함수 이부분 어려움.. */
/*
	tempMovingItem = { ...MovingItem }; //spread operator (배열 안의 값만 가져옴, 중요)
	// movingItem의 값이 변경되어도 tempMovingItem의 값이 변경되지 않음
	 // init을 하게되면 tempMovingItem을 잠깐 담아둠
	for (let i=0; i< game_rows; i++){
		prependNewLine()
	}	
	generateNewBlock()
}

function prependNewLine() {
	const li = document.createElement("li");
	const ul = document.createElement("ul");
	for (let j=0; j<game_cols; j++){
		
	const matrix = document.createElement("li");
		ul.prepend(matrix);
	}
	li.prepend(ul)
	playground.prepend(li)
}

function renderBlocks(moveType = ""){	//블럭을 좌표값에 맞게 그리는 함수
	const { type, direction, top, left} = tempMovingItem;
	const movingBlocks = document.querySelectorAll(".moving");
	movingBlocks.forEach(moving =>{
		moving.classList.remove(type, "moving");
	})
	
	blocks[type][direction].some(block=>{
		const x = block[0] + left; // ul안에 들어있는 li의 값
		const y = block[1] + top; // li의 row값
		const target = playground.childNodes[y]? playground.childNodes[y].childNodes[0].childNodes[x] : null;
		const isAvailable = checkEmpty(target);
		if(isAvailable){
			target.classList.add(type, "moving") // 명시 된 클래스를 추가하는 매서드
		} else{
			tempMovingItem = {...MovingItem}
			if(moveType === 'retry'){
				clearInterval(downInterval);
				showGameoverText()
			}
			setTimeout(()=>{
				renderBlocks('retry')
				if(moveType === "top"){
					seizeBlock();
				}
			
			},0)
			return true;
		}
		
	})
	MovingItem.left = left;
	MovingItem.top = top;
	MovingItem.direction = direction;
}
function seizeBlock(){ // 바닥까지 내려 갔을 때 더 이상 내려가지 않게 하는 함수
	const movingBlocks = document.querySelectorAll(".moving");
	movingBlocks.forEach(moving=>{
		moving.classList.remove("moving");
		moving.classList.add("seized");
	})
	checkMatch()
	
}
function checkMatch(){
	const childNodes = playground.childNodes;
	childNodes.forEach(child=>{
		let matched = true;
		child.children[0].childNodes.forEach(li=>{
			if(!li.classList.contains("seized")){
				matched = false;
			}
		})
		if(matched){
			child.remove();
			prependNewLine()
			score++;
			scoreDisplay.innerText = score;
		}
	})
	generateNewBlock()
}
function generateNewBlock(){
	clearInterval(downInterval);
	downInterval = setInterval(() => {
		moveBlock('top', 1)
	},duration)
	const blockArray = Object.entries(blocks);
	const randomIndex = Math.floor(Math.random() * blockArray.length);
	MovingItem.type = blockArray[randomIndex][0];
	MovingItem.top = 0;
	MovingItem.left = 3;
	MovingItem.direction = 0;
	tempMovingItem = {...MovingItem};
	renderBlocks()
}
function checkEmpty(target){
	if(!target || target.classList.contains("seized")){
		return false;
	}
	return true;
}
function moveBlock(moveType, amount){
	tempMovingItem[moveType] += amount;
	renderBlocks(moveType)
}
function changeDirection(){
	const direction = tempMovingItem.direction;
	direction === 3 ? tempMovingItem.direction = 0 : tempMovingItem.direction += 1;
	renderBlocks()
}
function dropBlock(){
	clearInterval(downInterval);
	downInterval = setInterval(() => {
		moveBlock("top",1)
	},10)
}
function showGameoverText(){
	gameText.style.display = "flex"
}
// event handling
document.addEventListener("keydown", e=>{
	switch(e.keyCode){
		case 39: //39: right
			moveBlock("left", 1);
			break;
		case 37: //37: left
			moveBlock("left", -1);  
			break;
		case 40: //40: down
			moveBlock("top", 1);
			break;
		case 38:
			changeDirection();
			break;	
		case 32:
			dropBlock();
			break;
		default:
			break;
	}
})
restartButton.addEventListener("click",()=>{
	playground.innerHTML = "";
	gameText.style.display = "none"
	init()
})
 */