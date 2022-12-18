package begin;

import java.io.UnsupportedEncodingException;

public class StringEx {

	public static void main(String[] args) {
		String s1 = "홍길동";
		String s2 = "홍길동";
		System.out.println(s1==s2); //true
		System.out.println(s1.equals(s2)); //문자 열 비교 , true
		
		//그러나
		String s3 = new String( "일지매" );
		String s4 = new String( "일지매" );
		/* String으로 선언된 변수는 단어 그 자체가 아니라 주소값만 가져오기 때문에 항상 4Byte다.
		   new String()으로 선언된 변수는 heap메모리에 단어를 찾지 않고 일단 생성한다. */
		System.out.println(s3==s4); // false / new String으로 선언되어 주소값이 다르기 때문.
		System.out.println(s3.equals(s4)); //문자 열 비교 , true
		System.out.println("------------------");
		
		String jumin = "123456-1";
		// jumin.charAt(6); <- X
		char c = jumin.charAt(7);
		System.out.println(c); // 1	
		
		int r = Character.getNumericValue(c);
		String str = null;
		str = (r%2==0)? "여자" : "남자";
		System.out.println("C=" + c);
		System.out.println("성별: " + str);
		if(c== '1' || c=='3')   str = "~~~남자~~~";
		else					str = "~~~여자~~~";
		System.out.println(str);
		
/* String pn="123R456"인 경우 4번째 값이 
 * R:red, B:blue, G:green 색을 나타내고 있다. 위의 pn을 확인하여 어떤색의 제품인지 출력
 */
String pn="123z456";

char a = pn.charAt(3);
int b = Character.getNumericValue(a);

String str1 = null;
if(a == 'R') {str1 = "빨간색";}
else if(a == 'G') {str1 = "초록색";}
else if(a == 'B') {str1 = "파란색";}
else str1 = "error!!";

System.out.println(str1 + "입니다.");

// getBytes -------------------------------------------------
System.out.println("------------------");

str = "abc 123 가나다";
try {
	byte[] euc = str.getBytes("euc-kr");
	byte[] ksc = str.getBytes("ksc5601");
	byte[] iso = str.getBytes("iso8859-1");
	byte[] utf = str.getBytes("UTF-8");
	
	System.out.println("euc: " + new String(euc));
	System.out.println("ksc: " + new String(ksc));
	System.out.println("iso: " + new String(iso));
	System.out.println("utf: " + new String(utf));
} catch (UnsupportedEncodingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	// try ~ catch : 오류가 날 가능성이 있는 코드를 catch하겠다 -> 
	// 				 발생 된 오류를 조치하고 다시 실행하게 하거나 안전하게 프로그램을 끝내게 하는 구절
}




		
	}
}
