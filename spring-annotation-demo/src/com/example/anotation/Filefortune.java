package com.example.anotation;

import org.springframework.stereotype.Component;

@Component
public class Filefortune implements FortuneService
{

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Welcome to file fortune";
	}

}
