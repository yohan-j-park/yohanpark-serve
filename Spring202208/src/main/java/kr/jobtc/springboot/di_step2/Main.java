package kr.jobtc.springboot.di_step2;

public class Main {

	public Main(Sql sql) {
		sql.crud();
	}
	
	public static void main(String[] args) {
		Assembler ab = new Assembler();
		Main m = new Main(ab.getSql());
	}

}
