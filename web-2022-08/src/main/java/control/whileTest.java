package control;

// 1~10까지 출력
public class whileTest {
	public void test1() {
		int a=1;
		while(a<=10) {
			System.out.println(a);
			a++;
		}
		System.out.println("------------------------");
	}
// 1~100사이 수 중 3,5의 공배수	
	public void test2() {
		int b=3;
		while(b<=100) {
			if(b%5==0) { 
			System.out.println(b);
			}
			b+=3;
		}
		System.out.println("------------------------");
	}
// 1~10 수 중 홀수면 continue(이번 반복을 빠져나가 다음 반복으로 넘어감), 짝수면 출력	
	public void test3() {
		int c=0;
		
		while(c<=10) {
			c++;
			if(c%2==1)   continue;
			System.out.println(c);			
		}
		System.out.println("------------------------");
	}
	
// 1~100까지 while을 반복할 때 10 이상이면 break	
	public void test4() {
		int d=1;
		while(d<=100) {
			d++;
			if(d>=10) break;
			System.out.println(d);
		}
		System.out.println("------------------------");
	}

// i는 1에서부터 1씩 증가. 합계가 1000 이상이 될 때 i값 출력	
	public void test5() {
		int i=0;
		int sum=0;
		while(true) {
			if(sum>=1000) {
				break;
			}
			i++;
			sum +=i;
		}
		System.out.println(i);
		System.out.println(sum);
		System.out.println("------------------------");
	}
// 124의 약수들을 나열	
	public void test6() {
	int i=0;
	while(i<=124) {
		i++;
		if(124%i==0) {
			System.out.println(i);
		}
	}
	System.out.println("------------------------");
}
/*
	 int i=1;
	 int su=124;
	 while(i<su){
	 i++;
	 if(su%i==0){System.out.println(i;)
 */
// y=2x+10 방정식의 해를 구하시오(x>=1, y<=33)
	public void test7() {
		int x =0;
		int y =0;
		while(y<=33) {
			x++;
			y=(2*x+10);
			if(y>33) break;
				System.out.print("x:" + x);
				System.out.println(" y:" + y);		
		}
	}
	/* 
	 int i=0;
	 int x=0;
	 int y=0;
	 while(true){
	 	x++;
	 	y=2*x+10;
	 	if(y>33) break;
	 	System.out.printf("(%d,%d) \n" , x,y);
	 }
	 */

	public void test8() {
		//x^2 + y^2 = 340
		
	}
	public static void main(String[] args) { 
		whileTest abc = new whileTest(); 
		abc.test1(); 
		System.out.println(' '); 
		abc.test2(); 
		System.out.println(' '); 
		abc.test3(); 
		System.out.println(' '); 
		abc.test4(); 
		System.out.println(' '); 
		abc.test5(); 
		System.out.println(' ');  
		abc.test6(); 
		System.out.println(' ');   
		abc.test7(); 
		System.out.println(' ');
		abc.test8(); 
		System.out.println(' ');
	}
}
