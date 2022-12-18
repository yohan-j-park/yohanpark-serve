package control;

public class BreakAndContinue {
	public void breakTest() {
		int n=1;
		while(n<10) {
			System.out.print(n + " ");
			if(n>=5) break;
			n++; // n++도 위치를 어디에 두냐에 따라 같은 식이어도 결과가 달라질 수 있다.
		}
	}
	
	public static void main(String[] args) {
		BreakAndContinue ex = new BreakAndContinue();
		ex.breakTest();
	}
}
