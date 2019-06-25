package com.example.annotation;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {

	private FortuneService myFortuneService;

	public FootBallCoach() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public FootBallCoach(FortuneService myFortuneService) {
		super();
		this.myFortuneService = myFortuneService;
	}

	@Override
	public String getDailyFortune() {

		return myFortuneService.getFortune();
	}
	


}
