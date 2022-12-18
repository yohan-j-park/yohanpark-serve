package kr.jobtc.springboot.di_step2;


// 객체를 생성하여 리턴해주는 외부 조립기 역할
public class Assembler {
	
	public Sql getSql() {
		return new Oracle();
	}
	
	// Assembler의 return부분만 고쳐주면 Main에서 계속 생성자를 생성하지 않아도 됨
}
