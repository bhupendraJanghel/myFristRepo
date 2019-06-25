package com.example.anotation;

import org.springframework.stereotype.Component;

@Component("theCoach")
public class TennisCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		return "practice back hand today !!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
