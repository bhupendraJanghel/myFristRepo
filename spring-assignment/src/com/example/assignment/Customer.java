package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:file.properties")
public class Customer implements Human {

	@Value("${foo.customername}")
	private String customerName;
	@Value("${foo.customerid}")
	private int customerId;
	
	@Autowired
	@Qualifier("homeAddress")
	private Address address;


	

	public Address getAddress() {
		return address;
	}


	public String getCustomerName() {
		return customerName;
	}


	public int getCustomerId() {
		return customerId;
	}


	@Override
	public String getHumanDetail() {

		return this.toString();
		
	}


	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", address=" + address + "]";
	}
	

}
