package com.example.springbootRestEmployee.dao;

import java.util.List;

import com.example.springbootRestEmployee.entity.Employee;

public interface EmployeeDao {

	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public Employee saveEmployee(Employee employee);
	public void deleteEmployee();
}
