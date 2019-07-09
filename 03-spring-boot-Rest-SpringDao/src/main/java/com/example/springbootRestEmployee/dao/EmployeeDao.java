package com.example.springbootRestEmployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootRestEmployee.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
