package comm.example.springdemo.dao;

import java.util.List;

import comm.example.springdemo.entity.Customer;

public interface CustomerDao {

	public void createCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public Customer getCustomerById(int id);

	public void deleteCustomer(int id);

	public void updateCustomer(Customer customer);
}
