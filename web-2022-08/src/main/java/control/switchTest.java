package control;

public class switchTest {
	
	public switchTest() {
		char code ='a';
		int price = 0;
		int ea	  = 100;
		int amt   = 0;
		
		switch(code) {
		case 'a' : price = 5; break;
		case 'b' : price = 3; break;
		default : price =  1; break;
		}
		amt = price*ea;
		System.out.println("금액: " + amt + "원");
		
		int a = 1;
		while(a<=10) {
			System.out.println('*');
			a++;
		}
	}
	/* 1~100사이의 수 중 3과 5의 공배수 출력 */
	public void test1() {
		int su = 3;
	}
	/* continue 사용 예(1~10사이의 수 중 홀수이면 다음수로 이동하고 짝수이면 출력하기 */
	public void test2() {
		
	}
	/* break 사용 예(10이상인 수가 되면 while 종료하기 */
	public void test3() {
		
	}
	public static void main(String[] args) {
		switchTest test = new switchTest();
		
		
	}
}
