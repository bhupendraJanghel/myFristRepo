package com.example.anotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach myCoach=context.getBean("theCoach",Coach.class);
		System.out.println(myCoach.getDailyWorkout());
		
		
		//by default the component name is same as class name with first letter small
		
		Coach myCoach2=context.getBean("footballCoach",Coach.class);
		
		System.out.println(myCoach2.getDailyWorkout());
		
		//if Class name start with 2 capital letters then the name of component is same as the class name
		
		Coach myDog=context.getBean("DOGCoach",Coach.class);
		System.out.println(myDog.getDailyWorkout());
		
		
		Coach myCoach3=context.getBean("footballCoach",Coach.class);
		System.out.println(myCoach3.getDailyWorkout());
		System.out.println(myCoach3.getDailyFortune());
		
		//injecting literal values through @value

		FootballCoach coach4=context.getBean("footballCoach",FootballCoach.class);
		
		System.out.println(coach4.getEmail());
		System.out.println(coach4.getTeam());
		
		
		
		
		//----------------------------------------------
		System.out.println("-----------------------------");
		
		AnnotationConfigApplicationContext contxt=new AnnotationConfigApplicationContext(SportsConfig.class);
		
		Coach myCoach1=contxt.getBean("swimCoach",Coach.class);
		
		System.out.println(myCoach1.getDailyFortune());
		System.out.println(myCoach1.getDailyWorkout());
		
		context.close();

	}

}
