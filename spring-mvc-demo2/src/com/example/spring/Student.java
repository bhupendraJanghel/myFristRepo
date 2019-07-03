package com.example.spring;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Student {

	@NotNull(message = "field can't be null")
	@Size(min = 1,message = "first name is required")
	private String first_name;
	private String last_name;
	private String country;
	
	private String[] language;
	private int id;
	private LinkedHashMap<String, String> countries = new LinkedHashMap<String, String>();

	private String favoriteLanguage;

	private String[] operatingSystem= {"Windows","MAC","Linux"};
	private String os;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Student() {
		super();
		countries.put("BR", "Brazil");
		countries.put("IN", "India");
		countries.put("US", "United State");
		countries.put("FR", "France");
	}

	public Student(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Student(String first_name, String last_name, String country, LinkedHashMap<String, String> countries) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.country = country;
		this.countries = countries;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}

	public Student(String first_name, String last_name, String country, LinkedHashMap<String, String> countries,
			String[] language) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.country = country;
		this.countries = countries;
		this.language = language;
	}

	public void setLanguage(String[] language) {
		this.language = language;
	}

	public String[] getLanguage() {
		return language;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	
}
