package com.example.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.demo.Student;

public class StudentDaoImpl implements StudentDao {

	private SessionFactory factory;
	private Session session;
	Scanner sc=new Scanner(System.in);
	public StudentDaoImpl() {
		super();
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		session=factory.openSession();
	}

	@Override
	public void createStudent(Student student) {
	
		session.getTransaction().begin();
		session.persist(student);
		session.getTransaction().commit();
		

	}

	@Override
	public List<Student> getAllStudent() {
		
		Query query=session.createQuery("from Student");
		return query.getResultList();
	}

	@Override
	public Student getStudentById(int id) {
		
		return session.get(Student.class,new Integer(id));
	}

	@Override
	public void deleteById(int id) {
		Student s=new Student();
		s.setId(id);
		 session.delete(s);
		
	}

	@Override
	public List<Student> getStudentByName(String Name) {
		
		Query query=session.createNamedQuery("findByName").setString("fName", Name);
		return query.getResultList();
	}

	@Override
	public void update(int id) {
		
		Student s=session.get(Student.class, new Integer(id));
		String choice=null;
		if(s!=null)
		{
			System.out.println("First Name:"+s.getFirstName());
			System.out.println("Want to change first name:");
			choice=sc.next();
			if(choice=="yes")
			{ 
				System.out.println("Enter New First name:");
				String fname=sc.next();
				s.setFirstName(fname);
			}
			
			session.getTransaction().begin();
			session.merge(s);
		}
		
	}

}
