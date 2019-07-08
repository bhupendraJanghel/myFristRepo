package comm.example.springdemo.service;

import java.util.List;

import comm.example.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomer();

	public void createCustomer(Customer customer);

	public void deleteCustomer(int id);
	
	public void updateCustomer(Customer customer);
}
