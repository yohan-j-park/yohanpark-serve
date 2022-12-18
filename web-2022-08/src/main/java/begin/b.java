package begin;

public class b {
	public b() {
		char alpha = 'a';
		char number = '1';
		char hangul = '한';
	
		System.out.println(alpha + "," + number + "," + hangul);
		
		alpha += 1;
		number += 1;
		hangul += 1;
		char c1 = '한';
		char c2 = '0';
		c1 += 1;
		c2 += 1;
		
		System.out.println(alpha + "," + number + "," + hangul);
		System.out.println(c2); // 1
	}
	public static void main(String[] args) {
		
		b c = new b();
	}

}
