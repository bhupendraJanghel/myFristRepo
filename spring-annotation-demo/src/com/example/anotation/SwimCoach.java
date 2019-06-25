package com.example.anotation;

import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

	
	private FortuneService fortuneService;
	@Override
	public String getDailyWorkout() {
			return "don't swim today";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

	public SwimCoach() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	
	
	
	
}
