package kr.jobtc.springboot.aop_step1;

public class AopDao {
	public void select() {
		System.out.println("select");
		System.out.println("log.....select");		//횡단적 관심사, 관점
	}
	public void insert() {
		System.out.println("insert");
		System.out.println("log.....insert");		
	}
	public void update() {
		System.out.println("update");
		System.out.println("log.....update");
	}				//횡단적 관심사, 관점
	public void delete() {
		System.out.println("delete");
		System.out.println("log.....delete");
	}
	
	
}
