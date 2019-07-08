package comm.example.springdemo.service;

import java.util.List;

import comm.example.springdemo.entity.Customer;

public interface CustomerService {

	public void createCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

	public void updateCustomer(Customer customer);

}
