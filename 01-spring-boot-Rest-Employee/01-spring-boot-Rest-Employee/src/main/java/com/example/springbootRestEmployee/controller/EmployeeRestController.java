package com.example.springbootRestEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootRestEmployee.entity.Employee;
import com.example.springbootRestEmployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService service;

	@Autowired
	public EmployeeRestController(EmployeeService service) {
		super();
		this.service = service;
	}

	@RequestMapping("/")
	public String getSomething() {
		return "welcome";
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {

		return service.getAllEmployee();
	}
	
	@GetMapping("/employees/{id}")
	public Employee findEmployeeById(@PathVariable int id)
	{ 
		Employee employee=service.getEmployeeById(id);
		if(employee==null)
			throw new EmployeeNotFoundException("Employee id is not available"+id);
		return employee;
	}
}