package com.example.assignment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:officeAddress.properties")
public class OfficeAddress implements Address {
	
	
	

	public OfficeAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Value("${land}")
	private String land;
	@Value("${mobile}")
	private String mobile;
	@Override
	public String getAddress() {
		
		return this.toString();
	}
	
	@Override
	public String toString() {
		return "OfficeAddress [land=" + land + ", mobile=" + mobile + "]";
	}

	public String getLand() {
		return land;
	}
	public String getMobile() {
		return mobile;
	}
	

}
