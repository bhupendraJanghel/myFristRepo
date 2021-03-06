package com.example.springbootconverter.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

	
   
	  private double rupee;
	  
	  @RequestMapping("/")
	  public String welcome()
	  { 
		  return "welcome";
	  }
	  
	  @GetMapping("/{rupee}")
	  public String convert(@PathVariable double rupee)
	  {
		   return "Dollar : "+rupee/68.66; 
	  }
	
}
