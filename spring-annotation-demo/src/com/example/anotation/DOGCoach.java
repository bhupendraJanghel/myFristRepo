package com.example.anotation;

import org.springframework.stereotype.Component;

@Component
public class DOGCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "feed your puppy today";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
