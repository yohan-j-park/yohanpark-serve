package begin;

public class StringEx3 {

	// 생성자 1)   반환형이 없다. 2) class명과 생성자명은 같아야 한다.
	//		사용: 객체가 생성될 때, 객체를 초기화
	//      생성자가 하나라도 선언되면 JVM은 생성자를 빌려주지 않는다.
	public StringEx3() {
		System.out.println("!!!!!!!!!!!!!!!!!!!생성자!!!!!!!!!!!!!!!!!!!");
		  // class명 인스턴스명 = new 생성자명();
		StringBuilder b1 = new StringBuilder("abc");
		StringBuilder b2 = new StringBuilder("abc");
		
		if(b1 == b2) System.out.println("b1, b2는 같다.");
		else 		 System.out.println("b1, b2는 다르다.");
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		
		if(s1 == s2) System.out.println("s1과 s2는 같다.");
		else 		 System.out.println("s1과 s2는 다르다.");
		
		if(s1.equals(s2)) System.out.println("같다.....");
		else 			  System.out.println("다르다.");
	}
	/* [미션]
	   1) StringEx3 class에 public void test() method 추가
	   2) test()메소드 안에 'StringEx3.test' 문자열 출력
	   3) test()메소드를 실행시켜 문자열 확인
	   4) test()에서 추가: StringBuilder 객체를 생성 후 객체 안에 이름, 주소, 연락처를 추가 한 뒤
	    				객체안의 문자열을 고정 문자열로 바꾸어 화면에 출력
    */
	
	public void test() { // 반환값이 없는 test method
		System.out.println("StringEx3.test");
		StringBuilder source = new StringBuilder(); // StringBuilder 객체를 생성
		source.append("\n이름: hong\n");
		source.append("주소: 서울\n");
		source.append("연락처: 010\n");
		
		System.out.println(source);
		System.out.println(source.toString());
		
	}
	
	public static void main(String[] anything) {
		StringEx3 ex3 = new StringEx3();
		ex3.test(); 
	}
		

}