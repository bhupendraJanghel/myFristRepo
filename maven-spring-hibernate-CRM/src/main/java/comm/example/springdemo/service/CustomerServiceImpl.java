package comm.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.example.springdemo.dao.CustomerDao;
import comm.example.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	
	@Override
	public List<Customer> getAllCustomer() {
		return dao.getAllCustomer();
	}

	@Override
	public void createCustomer(Customer customer) {
		dao.createCustomer(customer);
		
	}

	@Override
	public void deleteCustomer(int id) {
		dao.deleteCustomer(id);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
	dao.updateCustomer(customer);
	}

}
