package comm.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import comm.example.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private Session session;

	@Autowired
	private SessionFactory sessionFactory;

	
	public void createCustomer(Customer customer) {
		session = sessionFactory.openSession();
		
		session.saveOrUpdate(customer);

	}

	public List<Customer> getAllCustomer() {
		session = sessionFactory.openSession();

		
		Query<Customer> query = session.createQuery("from Customer", Customer.class);
	
		return query.getResultList();
	}

	public Customer getCustomerById(int id) {
		session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, id);
	return customer;

	}

	
	public void deleteCustomer(int id) {

		session = sessionFactory.openSession();

		Customer customer = session.get(Customer.class, id);
		if (customer != null) {
			session.getTransaction().begin();
			session.delete(customer);
			session.getTransaction().commit();
		}

	}

	@Transactional
	public void updateCustomer(Customer customer) {

	}

}
