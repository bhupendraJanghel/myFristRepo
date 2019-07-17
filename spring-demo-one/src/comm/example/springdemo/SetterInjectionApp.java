package comm.example.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"properties-applicationContext.xml");

		// CricketCoach myCoach=context.getBean("myCoach",CricketCoach.class);
		TennisCoach myCoach = context.getBean("myCoach", TennisCoach.class);
		
		/*
		 * System.out.println("email address==>" + myCoach.getEmail());
		 * System.out.println("team==>" + myCoach.getTeam());
		 * System.out.println(myCoach.getDailyWorkout());
		 */
		// System.out.println(myCoach.getDailyFortune());

		TennisCoach alphaCoach = context.getBean("myCoach", TennisCoach.class);
		
		
		boolean result=(myCoach==alphaCoach);
		
		//if scope is singleton then,both object return same location
		//if scope is prototype then, both having different location
		
		System.out.println("The myCoach and tenniscoach refer to the same object : "+result);
		System.out.println("myCoach location=>"+myCoach);
		System.out.println("alphaCoach location=>"+alphaCoach);
		
	}

}
