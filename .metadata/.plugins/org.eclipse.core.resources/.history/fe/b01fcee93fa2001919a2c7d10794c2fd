package com.example.springbootRestEmployee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootRestEmployee.entity.Customer;
import com.example.springbootRestEmployee.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CusotmerController {

	
	private CustomerService service;
	
	@Autowired
	public CusotmerController(CustomerService service) {
		super();
		this.service = service;
	}
	@GetMapping("/customers")
	public List<Customer> getAllCustomer(){
		 return service.getAllCustomer();
	}
	@GetMapping("/customers/{id}")
	public Optional<Customer> getCustomerById(@PathVariable int id)
	{
		return service.getCustomerById(id);
	}
	
	@PostMapping("/customers")
	public void saveCustomer(@RequestBody Customer customer)
	{
		service.saveCusotmer(customer);
	}
	
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id ) { 
		service.deleteCustomer(id);
	}
}

