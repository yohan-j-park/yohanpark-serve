package control;

public class forExam {
	// 두 수를 매개변수로 전달받아 두 수와 두 수 사이의 소수를 출력하시오
	public void test1(int x, int y) {

		System.out.println(x);
		System.out.println(y);
		for(int i=2; i<=y; i++) {
			int count = 0;
			for(int j=x; j<=y; j++) {
				if(i%j==0) {
					count += 1;
				}
			}
			if(count==2) {
				System.out.println(i);
			}			
			
		}
	}
	// 정수를 입력 받아 아래와 같이 출력하시오 test2
	public void test2(int x) {
		for (int i=1; i<x; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
			for(int i=0; i<x; i++) {
				for(int j=3; j>i; j--) {
					System.out.print("*");
				}			
				System.out.println();
			}
	}
	// 세 정수 x,y,z를 매개변수로 전달받아 x~y까지의 수 중 z배수의 값을 출력하시오.
	public void test3(int x, int y, int z) {
		for(int i=x; i<=y; i++) {
			if(i%z==0) {
				System.out.println(i);
			}
		}
	}
	
	// 두 정수 x,y를 매개변수로 전달 받아 아래와 같이 출력하시오 test4(int x, int y)
	public void test4(int x, int y) {
		for(int i=x; i<=y; i++) {
			for (int j=i; j<=y; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		forExam abc = new forExam();
		abc.test1(1, 50);
		System.out.println("--------------------------");
		abc.test2(3);
		System.out.println("--------------------------");
		abc.test3(1,20,3);
		System.out.println("--------------------------");
		abc.test4(1,5);
	}
}