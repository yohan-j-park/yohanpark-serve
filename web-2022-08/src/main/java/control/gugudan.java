package control;

public class gugudan {
	// 내가 하던 방식대로 출력
	public void test1() {
		for(int i=2; i<=9; i++) {
			System.out.println(i + "단");
			for(int j=1; j<=9; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
		}
	}
	// 수업ver
	/*
	 1) int r=0; --> 필드
	 gugudan(){
	 	2) int r=0; --> 지역형 변수(해당 메서드 안에서 사용 가능)
	 	for(int dan=2; dan<=9; dan++){
	 		3) int r=0; --> for문 안에서만 사용 가능
	 		System.out.println(dan+ " 단");
	 		for(int i=1; i<=9; i++){
	 			r = dan*i;
	 			System.out.printf("%d X %d = %d", dan,i,r);
	 			System.out.println();
	 		}
	 	}
	 
	 */
	// printf를 사용하여 출력
	public void test2() {
		int r=0;
		for(int i=2; i<=9; i++) {
			System.out.println(i + "단");
			for(int j=1; j<=9; j++) {
				r = i*j;
				System.out.printf("%d X %d = %d \n" , i,j,r);
			}
		}
	}
	// 100만원을 투자하여 매일 1%씩 복리로 수익을 봤을 때 1년후 금액은?
	public void test3() {
		double won = 10000000;
		// double won = 1000000d;
		double bokri = 0.95;
		for(int i=1; i<=365; i++) {
		won = won*bokri;
			System.out.println(i+ "일차: " + won);
			
		}
	}
	public static void main(String[] args) {
		gugudan abc = new gugudan();
		abc.test1();
		System.out.println("----------------------------------");
		abc.test2();
		System.out.println("----------------------------------");
		abc.test3();
	}
}
