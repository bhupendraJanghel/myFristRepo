package com.example.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach=context.getBean("footBallCoach",Coach.class);
		
		System.out.println(myCoach.getDailyFortune());
		
		context.close();
	}

}
