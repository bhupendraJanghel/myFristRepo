package comm.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HookupApp {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("init-destroy-applicationContext.xml");
		
		Coach myCoach=context.getBean("myCoach",Coach.class);
		
		
		

	}

}
