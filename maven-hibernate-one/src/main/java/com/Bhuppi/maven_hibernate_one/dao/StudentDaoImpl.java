package com.Bhuppi.maven_hibernate_one.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Bhuppi.maven_hibernate_one.Student;

public class StudentDaoImpl implements StudentDao {

	private SessionFactory factory;
	private Session session;
	Scanner sc = new Scanner(System.in);

	public StudentDaoImpl() {
		super();
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		session = factory.openSession();
	}

	@Override
	public void createStudent(Student student) {

		session.getTransaction().begin();
		session.persist(student);
		session.getTransaction().commit();

	}

	@Override
	public List<Student> getAllStudent() {

		Query query = session.createQuery("from Student");
		return query.getResultList();
	}

	@Override
	public Student getStudentById(int id) {

		return session.get(Student.class, new Integer(id));
	}

	@Override
	public void deleteById(int id) {

		Student st = session.get(Student.class, id);
		if (st != null) {
			session.getTransaction().begin();
			session.delete(st);
			session.getTransaction().commit();
		}

	}

	@Override
	public List<Student> getStudentByName(String Name) {

		Query query = session.createNamedQuery("findByName").setString("fName", Name);
		return query.getResultList();
	}

	@Override
	public void update(int id) {
		Student s = session.get(Student.class, new Integer(id));
		String choice = null;
		if (s != null) {
			System.out.println("First Name:" + s.getFirstName());
			System.out.println("Do Want to change first name:");
			choice = sc.next();
			if (choice.equals("yes")) {
				System.out.println("Enter New First name:");
				String fname = sc.next();
				s.setFirstName(fname);

			} /*
				 * System.out.println("Last Name:" + s.getLastName());
				 * System.out.println("Do Want to change Last name:"); choice = sc.next(); if
				 * (choice.equals("yes")) { System.out.println("Enter New Last name:"); String
				 * lname = sc.next(); s.setLastName(lname); } System.out.println("Email:" +
				 * s.getEmail()); System.out.println("Do Want to change Email:"); choice =
				 * sc.next(); if (choice.equals("yes")) {
				 * System.out.println("Enter New Email:"); String email = sc.next();
				 * s.setLastName(email); }
				 */
			System.out.println("start");
			session.getTransaction().begin();
			session.merge(s);
			session.getTransaction().commit();
			System.out.println("End");
		}
	}
}
