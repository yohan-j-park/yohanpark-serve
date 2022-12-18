package kr.jobtc.springboot.aop_step2;

public class AopDao {
	public void select() {
		System.out.println("AopDao.select");
	}
	public void insert() {
		System.out.println("AopDao.insert");
	}
	public void update() {
		System.out.println("AopDao.update");
	}				//횡단적 관심사, 관점
	public void delete() {
		System.out.println("AopDao.delete");
	}	
}
