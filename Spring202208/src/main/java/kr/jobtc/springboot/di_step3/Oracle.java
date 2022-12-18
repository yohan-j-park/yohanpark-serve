package kr.jobtc.springboot.di_step3;

public class Oracle implements Sql{

	@Override
	public void crud() {
		System.out.println("Oracle.crud");
	}

}
