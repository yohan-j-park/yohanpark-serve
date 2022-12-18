package control;

public class forTest {
// 1부터 parameter로 전달된 정수까지 출력
	public void test1(int su) {
		int i=0;
		for(i=1; i<=su; i++) {
			System.out.print(i + " ");
		}
		System.out.println("  ");
		System.out.println("-------------------");
	}
// 1부터 parameter로 전달된 정수 중에서 홀수만 더한 값 출력
	public void test2(int su) {
		int sum = 0;
		int i=1;
		for(i=1; i<=su; i++) {
			if(i%2==1) {
				sum += i;	
		/* 
		  int i=0;
		  int hap=0;
		  for(i=1; i<=su; i=i+2;
		  hap += i; */
			}
		}
		// System.out.printf("1~%d(su)까지 홀수의 합 = %d(hap) \n", su, hap);
		System.out.println(sum);
		System.out.println("-------------------");
	}
// parameter로 전달된 수에 해당하는 구구단 출력
	public void test3(int dan) {
		for(int i=1; i<=9; i++) {
			System.out.println(dan + "x" + i + "=" + dan*i);
		}
		System.out.println("-------------------");
	}
	/* 
	 int r=0;
	 for(int i=1; i<=9; i++){
	 r=dan*i;
	 System.out.printf("%d*%d = %d \n", dan, i, r); 
	 */
	
// 1부터 parameter로 전달된 수 까지의 합계가 1500이상이 되는 시점의 값과 합계 출력	
	public void test4(int n) {
		int hap = 0;
		int i=1;
		for(i=1; i<n; i++) {
			hap += i;
			if(hap>=1500) break;
		}
		System.out.println("1부터 " + n + "번째 까지의 합계 중에서 1500이상이 되는 시점은 몇 번째? " + i + " 번째 더한 값:" + hap);
	}
	/* 
	  int hap=0;
	  for(int i=1; i<=n && hap<1500 ; i++){
	  		hap += i;
	  }
	  System.out.printf("i=%d, hap=%d\n" , i, hap);
	  */
	
	public static void main(String[] args) {
		forTest abc = new forTest();
		abc.test1(10);
		abc.test2(100);
		abc.test3(9);
		abc.test4(100);
	}

}
