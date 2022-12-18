//package kr.jobtc.springboot.aop_step3;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//
//public class Main {
//	
//	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context =
//			new AnnotationConfigApplicationContext(AopConfig.class);
//		AopDao dao = (AopDao)context.getBean("getAopDao");
////		dao.select();
////		dao.insert();
////		dao.update();
////		dao.delete();
//		AroundTest at = (AroundTest)context.getBean("getAroundTest");
////		at.crud();	//pjp.procced()에 의해서 실행됨
////		at.test();
//		System.out.println("-".repeat(50));
//		StudentDao sDao = (StudentDao)context.getBean("getStudentDao");
//		sDao.select();
//		sDao.insert();
//		sDao.update();
//		sDao.delete();
//	}
//}
