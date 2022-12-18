//package kr.jobtc.springboot.aop_step1;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main {
//	
//	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context =
//			new AnnotationConfigApplicationContext(AopConfig.class);
//		AopDao dao = (AopDao)context.getBean("getAopDao");
//		dao.select();
//		dao.insert();
//		dao.update();
//		dao.delete();
//	}
//}
