package com.example.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String arg[])
	{
		  
		try {
		ObjectMapper mapper=new ObjectMapper();
		
		Student theStudent=mapper.readValue(new File("demo-lite.json"),Student.class);
		
		System.out.println(theStudent.getFirstName()+"  "+theStudent.getLastName());
		
		System.out.println(theStudent.getAddress().getCity()+"--"+theStudent.getAddress().getStreetAddress()+"--"+theStudent.getAddress().getZipCode());
		
		System.out.println(theStudent.getCountry());
		
		for(String lang :theStudent.getLanguage())
		System.out.print(lang+",");
		}catch(Exception e)
		{ 
			e.printStackTrace();
		}
	}

}
