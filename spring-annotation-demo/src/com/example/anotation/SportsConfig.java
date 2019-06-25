package com.example.anotation;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;


@Configuration

public class SportsConfig {
	
	@Bean
	public FortuneService fortuneService()
	{
		return new SadFortuneService();
	}
	@Bean
	public Coach swimCoach()
	{  
		return new SwimCoach(fortuneService());
	}
}
