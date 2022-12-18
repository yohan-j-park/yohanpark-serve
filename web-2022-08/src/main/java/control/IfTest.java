package control;

public class IfTest {
	/* 
	  1) 메소드 test1()을 추가
	  2) 정수형 변수 score를 추가하고 임의의 초기값을 대입
	  3) if문을 사용하여 80이상 합격, 80~40 보류 40미만 과락 출력
	*/
	public void test1() {
		int score = 80;
		if(score >= 80)System.out.println("점수:" + score + ", 결과: 합격");
		else if(score >=40) System.out.println("점수:" + score + ", 결과: 보류");
		else if(score<40) System.out.println("점수:" + score + ", 결과: 과락");
		System.out.println("------------------------------------------------");
		
		/* 
		 int score = 90;
		 String msg="";
		 if(score>=80) 			msg="합격";
		 else if(score>=40) 	msg="대기";
		 else 					msg="과락";
		 System.out.println(msg); 		  
		 */
	}
	
	/* 
	  1) 메소드 test2()을 추가
	  2) 정수형 변수 price를 추가하고 임의의 단가 입력, 정수형 변수 ea에 임의의 수량 입력
	  3) 정수형 변수 amount에 수량*단가를 계산하여 대입
	  4) 정수형 변수 tax에 부가세 계산
	  5) 정수형 변수 totAmount에 amount+tax 대입
	  6) 총액이 1000원 이상이면 '비행기'
	  		   500원 이상이면 '자동차'
	  		   300원 이상이면 '자전거'
	  		   그 외이면 'nothing'을 지급
	  7) 수량, 단가, 세금, 금액, 총액, 사은품 모두 출력
	*/
	public void test2() {
		int price = 1800;
		int ea = 2500;
		int amount = (int)(price * ea /1.1 + 0.5);
		int tax = (int)(amount * 0.1 + 0.5);
		int totAmount = (int)(amount + tax);
		String gift = "";
		
		if(totAmount>=1000) 	gift = "비행기"; 
		else if(totAmount>=500) gift = "자동차";
		else if(totAmount>=300) gift = "자전거";
		else 					gift = "없음";
		System.out.println("단 가: " + price + "원" + "\n" +
						   "수 량: " + ea + "개" + "\n" +
						   "금 액: " + amount + "원" + "\n" +
						   "부가세: " + tax + "원" + "\n" + 
						   "합 계: " + totAmount + "원" + "\n" +
						   "사은품: " + gift);

	}
	
	
	
	
	public static void main(String[] args) {
		IfTest abc = new IfTest();
		abc.test1();
		abc.test2();
	}
}
