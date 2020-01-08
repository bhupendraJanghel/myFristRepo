package com.example.springbootRestEmployee.service;

import java.util.List;
import java.util.Optional;

import com.example.springbootRestEmployee.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployee();

	public Optional<Employee> getEmployeeById(int id);

	public Employee saveEmployee(Employee employee);

	public void deleteEmployee(int id);
}