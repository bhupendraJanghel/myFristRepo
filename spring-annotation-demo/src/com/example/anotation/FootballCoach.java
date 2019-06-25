package com.example.anotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@PropertySource("classpath:source.properties")
public class FootballCoach implements Coach {
	
	//@Value("admin@gmail.com")
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	
//	@Autowired   //property level injection
//	@Qualifier("happyFortuneService")
	private FortuneService myFortuneService; // dependency injection

	public FootballCoach() {
		super();

	}

	/*
	 * @Autowired //example of contructores autowired public
	 * FootballCoach(FortuneService myFortuneService) { super();
	 * this.myFortuneService = myFortuneService; }
	 */

	/*
	 * @Autowired //example of setter level injection public void
	 * setMyFortuneService(FortuneService myFortuneService) { this.myFortuneService
	 * = myFortuneService; }
	 */
	
	/*
	 * @Autowired //example of method level injection public void
	 * FortuneService(FortuneService myFortuneService) { this.myFortuneService =
	 * myFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "practice forward today for 2 hrs.";
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return myFortuneService.getFortune();
	}

	
	@PostConstruct
	public void doSomeInitStuff()
	{ 
		System.out.println(">>inside dosomeinitStuff");
	}
	
	@PreDestroy
	public void doSomeCleanupStuff()
	{ 
		System.out.println(">>inside dosomeCleanupStuff");
	}

	@Autowired
	public void setMyFortuneService(@Qualifier("happyFortuneService")FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}
	
	
 

		
		
	
	
	
}
