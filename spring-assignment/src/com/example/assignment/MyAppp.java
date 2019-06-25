package com.example.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAppp {

	public static void main(String[] args) {
		
	
	
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
	
		Customer customer=context.getBean("customer",Customer.class);
		
		System.out.println(customer.getHumanDetail());
		
	}

}
