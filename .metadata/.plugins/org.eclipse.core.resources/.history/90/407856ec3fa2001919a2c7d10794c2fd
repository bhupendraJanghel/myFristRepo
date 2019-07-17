package com.example.springbootRestEmployee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootRestEmployee.controller.EmployeeNotFoundException;
import com.example.springbootRestEmployee.dao.CustomerDao;
import com.example.springbootRestEmployee.entity.Customer;
@Service
public class CutomerServiceimpl implements CustomerService {

	private CustomerDao dao;

	@Autowired
	public CutomerServiceimpl(CustomerDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Customer> getAllCustomer() {

		return dao.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(int id) {

		Optional<Customer> cust = dao.findById(id);
		if (!cust.isPresent())
			throw new EmployeeNotFoundException("Customer not found");
		return cust;
	}

	@Override
	public Customer saveCusotmer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.save(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		dao.deleteById(id);

	}

}
