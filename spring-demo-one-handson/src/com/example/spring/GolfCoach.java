package com.example.spring;

public class GolfCoach implements Coach {

	private FortuneService myFortuneService;

	public GolfCoach() {
		super();
	}



	public void setMyFortuneService(FortuneService myFortuneService) {
		this.myFortuneService = myFortuneService;
	}



	@Override
	public String getDailyWorkout() {
		return "pracitce your putting skill for 2 hrs. today! ";
	}

	@Override
	public String getDailyFortune() {

		return myFortuneService.getFortune();
	}

}
