//package kr.jobtc.springboot.aop_step2;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main {
//	
//	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context =
//			new AnnotationConfigApplicationContext(AopConfig.class);
//		AopDao dao = (AopDao)context.getBean("getAopDao");
//		Logout logout = (Logout)context.getBean("getLogout");
//		logout.run(dao,"select");
//		System.out.println();
//		logout.run(dao,"insert");
//		System.out.println();
//		logout.run(dao,"update");
//		System.out.println();
//		logout.run(dao,"delete");
//
//
//	}
//}
