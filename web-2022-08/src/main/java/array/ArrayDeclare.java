package array;

public class ArrayDeclare {
	ArrayDeclare(){
		// 크기를 지정하여 배열 선언
		int[] a = new int [5]; // 정수형 배열 a = 5자리이다.
		String[] s = new String[5];
		byte[] b = new byte[1024];
		Object[] obj = new Object[5];
		
		// 배열형만 선언하고 크기를 나중에 지정.
		int[] aa;
		aa = new int[5];
		
		String[] ss;
		ss = new String[5];
		
		byte[] bb;
		bb = new byte[1024];
		
		Object[] obj1;
		obj1 = new Object[5];
		
		// 초기값을 사용하여 배열 선언
		int[] aaa = {1,2,3,4,5};
		byte[] bbb = new byte[]{'a','b','c','d','e'}; // 명시적으로 표현
		String[] sss = {"가나다", "일이삼", "abc"};
		
		// 첨자를 사용하여 배열에 접근
		System.out.println(aaa[0]);
		System.out.println(bbb[1]);
		System.out.println(sss[2]);
	
		// 객체형 배열 사용하기
		Data[] d = new Data[5];
//		d[0].name = "kim"; // (x) NullPointer Exception
		Data abc = new Data(); // 데이터를 저장한 것이 아니라, 공간만 할당(주소)
		abc.name = "kim";
		d[0] = abc; // (O)
		System.out.println(d[0].name);
	}
	public static void main(String[] args) {
		new ArrayDeclare();
		
	}
}
