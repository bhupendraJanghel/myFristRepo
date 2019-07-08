package com.example.springbootdemo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBootController {

	@Value("${coach.name}")
	private String coach;
	@Value("${team.name}")
	private String team;
	
	
	@RequestMapping("/")
	public String sayHello()
	{ 
		return "hey welcome to spring boot! Current server time is:"+LocalDateTime.now();
	}
	@RequestMapping("/workout")
	public String getWorkout()
	{ 
		return "run hard 5km today";
	}
	@RequestMapping("/fortune")
	public String getFortune()
	{
		return "today is your lucky day.!!";
	}
	
	@RequestMapping("/teaminfo")
	public String getTeam()
	{ 
		return "Coach : "+coach+"Team : "+team;
	}
 		
}
