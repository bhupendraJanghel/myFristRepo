package comm.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comm.example.springdemo.dao.CustomerDao;
import comm.example.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;

	@Transactional
	public void createCustomer(Customer customer) {
		dao.createCustomer(customer);
	}

	public List<Customer> getAllCustomer() {

		return dao.getAllCustomer();
	}

	public Customer getCustomerById(int id) {

		return dao.getCustomerById(id);
	}
	@Transactional
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);

	}
	@Transactional
	public void updateCustomer(Customer customer) {
		dao.updateCustomer(customer);

	}

}
