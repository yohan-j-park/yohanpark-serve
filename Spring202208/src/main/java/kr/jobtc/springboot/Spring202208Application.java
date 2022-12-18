package kr.jobtc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Spring202208Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring202208Application.class, args);
	}

}
