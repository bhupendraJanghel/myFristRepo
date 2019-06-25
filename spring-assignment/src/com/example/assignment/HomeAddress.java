package com.example.assignment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component

@PropertySource("classpath:homeAddress.properties")

public class HomeAddress implements Address {

	@Value("${land}")
	private String land;
	@Value("$(mobile)")
	private String mobile;
	
	

	public HomeAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getAddress() {
		
		return this.toString();
	}

	
	@Override
	public String toString() {
		return "HomeAddress [land=" + land + ", mobile=" + mobile + "]";
	}

	public String getLand() {
		return land;
	}

	public String getMobile() {
		return mobile;
	}
	

}
