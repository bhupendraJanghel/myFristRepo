package comm.example.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import comm.example.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getAllCustomer() {

		Session session = sessionFactory.openSession();
		Query<Customer> query = session.createQuery("from Customer", Customer.class);

		return query.getResultList();
	}

	@Override
	@Transactional
	public void createCustomer(Customer customer) {
		
		Session session=sessionFactory.openSession();
		
		session.save(customer);
		
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session session=sessionFactory.openSession();
		Customer c=session.get(Customer.class, id);
		session.getTransaction().begin();
			session.delete(c);
			session.getTransaction().commit();
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		
	}

}
