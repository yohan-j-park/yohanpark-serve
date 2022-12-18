package begin;

public class A {
	public static void main(String[] anything) {
		System.out.println("Hello, World!");
		System.out.println("World, Hello!");
		System.out.println("Hello, World!"+ " " + "World, Hello!");
		System.out.println(10+10+" ");
		System.out.println(" "+10+10);
		System.out.println(Math.pow(2, 64)); 
		System.out.println('a'); // a
		System.out.println('0'); // 0
		System.out.println('0'+'0'); // 96
		System.out.println('-'); // -
		
		// 변수형
		boolean b1 = true; // true, false 중 하나만 가능
		boolean b2 = 10>20;
		
		System.out.println(b1);  // true
		System.out.println(b2);  // false
		
		// 문자형
		char c1 = '한';
		char c2 = '0';
		char c3 = '0';
		char c4 = 49;
		char c5 = 'a';
		c1 += 1;
		c2 += 1;
		c3 = ++c3;
		
System.out.println((char)49);
		
		System.out.println(c5);
		System.out.println(c1); //핝
		System.out.println("c1"); // c1
		System.out.println(c2); // 1
		System.out.println(c2+c2); // 98
		System.out.println('0'+1); // 49
		System.out.println('0'+1+'0'+1); // 98
		System.out.println(c4);
		System.out.println((char)13);
		
		// long타입
		long l1 = 10;
		/* promotion:형변환(casting) int는 4byte고 long은 8byte이므로 long으로 자동 변환됨 */
		
		//실수형
		float f1 = (float) 3.14;
		double f2 = 3.14;
		float f3 = 3.14f;
		
		// 정수형 연산은 결과값도 정수형이다.
		System.out.println(10/3); // 3
		System.out.println((double)10 / 4); // 2.5
	}
}
