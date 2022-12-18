package kr.jobtc.springboot.aop_step3;

public class StudentDao {
	public void insert() {
		System.out.println("StudentDao.insert");
	}
	public void select() {
		System.out.println("StudentDao.select");
	}
	public void update() {
		System.out.println("StudentDao.update");
	}
	public void delete() {
		System.out.println("StudentDao.delete");
	}
	
}
