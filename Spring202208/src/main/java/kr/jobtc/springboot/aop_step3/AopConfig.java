//package kr.jobtc.springboot.aop_step3;
//
//import java.io.FileWriter;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
////@COnfiguration 을 해야 @Bean을 만들 수 있음
//@Configuration
//@EnableAspectJAutoProxy		// 단일 페이지를 테스트하기 때문에 mainclass가 아니라 config에 사용함
//@Aspect
//public class AopConfig {
//	
//	public AopConfig() {
//		System.out.println("AopConfig()");
//	}
//	
//	@Bean
//	public AopDao getAopDao() {
//		return new AopDao();
//	}
//	
//	@Bean
//	public AroundTest getAroundTest() {
//		return new AroundTest();
//	}
//	
//	@Bean
//	public StudentDao getStudentDao() {
//		return new StudentDao();
//	}
//	
//	//가로챈 프로세스를 JoinPoint에 담는다.
//	//JoinPoint: AOP가 구현되기 위한 장소 타이밍에는 After, Before가 있다 / JoinPoint가 하나로 묶어서 관리해줌
//	//Before("execution(접근자 반환형 패키지명.클래스명.메서드명(매개변수))")
//	//		(* kr.jobtc.springboot.AopDao.*(..)) => AopDao클래스에 있는 어떤 메서드라도 실행되기전에
//	@Before("execution(* kr.jobtc.springboot.aop_step3.AopDao.*(..))")
//	public void beforeAdvice(JoinPoint jp) {	
//		System.out.println("log...........");
//		
//		//실행될 메서드명
//		System.out.println(jp.getSignature().getName());
//	}
//	
//	@Around("execution(* kr.jobtc.springboot.aop_step3.AroundTest.*(..))")	// AroundTest의 메소드가 실행되기 전후에
//	public void aroundAdvice(ProceedingJoinPoint pjp) {		// 위빙된 지점
//		System.out.println("around before");
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("around after");
//		
//	}
//	
//	@Before("execution(* kr.jobtc.springboot.aop_step3.StudentDao.select(..))")
//	public void stdbeforeAdvice(JoinPoint jp) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
//		Date d = Calendar.getInstance().getTime();
//		String nal = sdf.format(d);
//		//실행될 메서드명
//		String log = (nal + " >>> " + jp.getSignature().getName());
//		System.out.println(log);
//	}
//	
//	public void writeLog(String log) {
//		//log File
//		FileWriter fw;
//		SimpleDateFormat fileNameFrm = new SimpleDateFormat("yyyy-MM-dd");
//		String logFile = fileNameFrm.format(new Date()) + ".log";
//		try {
//			fw = new FileWriter(logFile, true);
//			fw.write(log);
//			fw.write("\n");
//			fw.close();
//		}catch(Throwable e) {
//			e.printStackTrace();;
//		}
//	}
//	
//	@Around("execution(* kr.jobtc.springboot.aop_step3.StudentDao.insert(..))"
//			+ " || execution(* kr.jobtc.springboot.aop_step3.StudentDao.update(..))"	// AroundTest의 메소드가 실행되기 전후에
//			+ " || execution(* kr.jobtc.springboot.aop_step3.StudentDao.delete(..))")	
//	public void stdaroundAdvice(ProceedingJoinPoint pjp) {		// 위빙된 지점
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E) hh:mm:ss:SS");
//		Date d = Calendar.getInstance().getTime();
//		String nal = sdf.format(d);
//		String log = "login pass : "
//				+ 	 (nal + " >>> " + pjp.getSignature().getName());
//		try {
//			pjp.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		log += "...end of log...";
//		System.out.println(log);
//		writeLog(log); 	// 로그를 파일로 저장
//		
//	}
//
//	
//}
