package com.example.springbootRestEmployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootRestEmployee.entity.Customer;

public interface CustomerDao  extends JpaRepository<Customer, Integer>{

}
