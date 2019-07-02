package com.example.json;

public class Address {

	private String city;
	private String streetAddress;
	private int zipCode;
	public Address(String city, String streetAddress, int zipCode) {
		super();
		this.city = city;
		this.streetAddress = streetAddress;
		this.zipCode = zipCode;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
}
