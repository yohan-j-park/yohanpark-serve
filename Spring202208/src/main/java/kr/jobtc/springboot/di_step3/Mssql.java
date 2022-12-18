package kr.jobtc.springboot.di_step3;

public class Mssql implements Sql{

	public Mssql() {
		System.out.println("Mssql");
		long beforeTime = System.currentTimeMillis();
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime);
		System.out.println("시간차이(m) : " + secDiffTime);
	}
	@Override
	public void crud() {
		System.out.println("Mssql.crud");
	}

}
