package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class helloController {

	@GetMapping("/")
	public String showPage() {
		return "index.jsp";
	}
	
	@GetMapping("/processForm")
	public String processForm()
	{ 
		return 
		
	}

}
