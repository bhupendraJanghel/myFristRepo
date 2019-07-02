package com.example.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private Address address;
	private String[] language;

	

	public Student(String firstName, String lastName, String country, Address address, String[] language) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.address = address;
		this.language = language;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String[] getLanguage() {
		return language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}

}
