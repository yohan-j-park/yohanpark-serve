package kr.jobtc.springboot.di_step2;

public class Mysql implements Sql{

	@Override
	public void crud() {
		System.out.println("Mysql.crud");
	}

}
