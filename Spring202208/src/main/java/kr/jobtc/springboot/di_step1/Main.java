package kr.jobtc.springboot.di_step1;

public class Main {
	// 외부 환경의 변화에 따라 내부에서도 생성자를 계속 추가했다(변화했다)
	public Main(Mysql m) {
		m.crud();
	}
	
	public Main(Oracle oracle) {
		oracle.crud();
	}
	
	public Main(Mssql ms) {
		ms.crud();
	}
	
	public static void main(String[] args) {
		Mysql sql = new Mysql();
		Main m = new Main(sql);
		//외부 환경의 변화
		Oracle oracle = new Oracle();
		m = new Main(oracle);
		
		Mssql ms = new Mssql();
		m = new Main(ms);
	}
}
