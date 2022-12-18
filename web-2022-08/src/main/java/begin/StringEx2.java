package begin; // package는 주석을 제외하고 맨 위에 써야 한다.
// package와 class 사이에는 import~ 밖에 올 수 없다.
// 메소드: 접근제한자 반환형 메소드명(매개변수들){ }   // method 안에 method는 생성할 수 없다.
public class StringEx2 {
	public void test() {
		System.out.println("---------------------");
		String str1 = "abcdefabc";
		String str2 = "abc가나다123";
		int len1 = str1.length();
		int len2 = str2.length();
		
		int index1 = str1.indexOf("c");
		int index2 = str2.lastIndexOf("2");
		int index3 = str2.indexOf("ab", 3); // str2의 문자열에서 3번째 이후부터 "ab"가 속하는 위치의 값을 찾아라
		// overloading: 같은 이름을 갖고 있지만, 서로 다른 매개변수 형식을 가지고 있는 메서드를 여러 개 정의하는 것.
		// 보통 하나의 메서드로 하나의 기능만 구현해지만 하나의 메서드로 여러 기능을 구현하기 때문에 붙여진 이름이다.
		System.out.println("len1= " + len1);
		System.out.println("len2= " + len2);
		System.out.println("index1= " + index1);
		System.out.println("index2= " + index2);
		System.out.println("index3= " + index3); // -1 (값이 없다)
		System.out.println("---------------------");
		
	}
	public void replaceTest() {
		
		System.out.println("replace-------------------");
		String source = "abc def 123 일이삼 가나다";
		String r1 = source.replace("일이삼","하나둘셋"); // 일이삼을 하나둘셋으로 변경
		System.out.println("r1= " + r1);
		String r2 = source.replaceAll("[1-3]","헛둘서이"); // (정규식) 1또는 2가 있으면 헛둘로 변경
		System.out.println("r2= " + r2);
	}
	
	public void substringTest() {
		System.out.println("substringTest-------------");
		String source = "abc def 123 가나다 abc 123 하나둘셋 원투쓰리";
		String sub = source.substring(0,3);  
		
		System.out.println(sub); // abc
		System.out.println(source.substring(source.length()-4)); // 원투쓰리
	}
	
	public void toLowerCaseTest() {
		System.out.println("toLowerCaseTest------------------------");
		String source = "ABcdEFgHI";
		String lowerCase = source.toLowerCase();
		System.out.println(lowerCase);
	}
	
	public void trimTest() {
		System.out.println("trimTest-------------------------------");
		String source = "     지그     재그";
		String trim = source.trim();
		System.out.println(source);
		System.out.println(trim);
	}
	
	public void valueOfTest() {
		System.out.println("valueOfTest-----------------------------");
		int num1 = 123;
		int num2 = 456;
		String num1vot = String.valueOf(num1);
		String num2vot = String.valueOf(num2);
		
		
		System.out.println(num1vot); // 123이 출력되지만 숫자 123이 아닌 문자열 "123"임
		System.out.println(num2vot); // 456이 출력되지만 숫자 456이 아닌 문자열 "456"임
	}
	
	public void splitTest() {
		System.out.println("spritTest---------------------------------");
		String source = "123,456.789/가나다-ㄱㄴㄷ";
		String[] splitsrc = source.split(",|\\.|/|-");
		for(String s : splitsrc) {
			System.out.println(s);		
		} 
	}
	
	public static void main(String[] kkk) { 	
		// 프로그램을 시작하는 기능을 하고 있다. java에 함수는 없지만 전통적으로 main만 함수라고 하고 있다.
		StringEx2 ex2 = new StringEx2();  //좌측 StringEx2는 class이고 오른쪽 StringEx2는 (생성자)Method이다.
		 								  // 해석: StringEx2생성자를 가지고 ex2라는 객체를 만들어라.
		ex2.test(); // ex2란 객체가 가지고있는 test method이다.
		/* ex2:객체 , StringEx2라는 class를 ex2라는 객체로 만들겠다. ex2는 변수인데 기본형 변수와는 다르게 StringEx2형 이다. 
		   ex2는 객체이고 오브젝트이며 memory에 올라간 object이기 때문에 인스턴스라고 불린다. */
		ex2.replaceTest();
		ex2.substringTest();
		ex2.toLowerCaseTest();
		ex2.trimTest();
		ex2.valueOfTest();
		ex2.splitTest();
	}
}
