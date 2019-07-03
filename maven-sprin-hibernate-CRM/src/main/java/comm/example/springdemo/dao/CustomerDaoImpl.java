package comm.example.springdemo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import comm.example.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getAllCustomer() {
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Customer");
		
		
		return query.getResultList();
	}

}
