//package kr.jobtc.springboot.member;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class Main {
//	//Spring 어플리케이션과 관계없이 실행시킴 , 비즈니스코드
//	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = 
//			new AnnotationConfigApplicationContext(Assembler.class);
//		
//		Member member = (Member)context.getBean("getMember");
//		member.crud();
//	}
//
//}
