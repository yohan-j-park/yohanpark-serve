package kr.jobtc.springboot.aop_step2;

public class Logout {	//step1에서 Dao에 있었던 log출력부분을 따로 빼냄
	AopDao dao;
	public void run(AopDao dao,String job) {
		this.dao = dao;
		System.out.println("log...AopDao 1"); 		// sysout ~ sysout : around Type

		switch(job) {
		case "select":
			this.dao.select();
			break;
		case "update":
			this.dao.update();
			break;
		case "insert":
			this.dao.insert();
			break;
		case "delete":
			this.dao.delete();
			break;
		}
		
		System.out.println("log...AopDao 2");
	}
}
