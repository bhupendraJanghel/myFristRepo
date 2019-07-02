package com.Bhuppi.maven_hibernate_two;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.Bhuppi.maven_hibernate_two.entity.Instructor;
import com.Bhuppi.maven_hibernate_two.entity.InstructorDetail;

public class App {
	public static void main(String[] args) {
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Instructor.class)
					.buildSessionFactory();
			Session session = factory.openSession();
			/*
			 * Student student=session.get(Student.class, 2);
			 * 
			 * if(student!=null) {
			 * 
			 * session.getTransaction().begin(); session.delete(student);
			 * 
			 * session.getTransaction().commit(); System.out.println("record deleted"); }
			 * 
			 * student.setFirstName("Sourav"); student.setLastName("Ganguly");
			 * student.setEmail("admin@yahoo.com"); session.getTransaction().begin();
			 * session.merge(student); session.getTransaction().commit();
			 */
			session.getTransaction().begin();
			/*
			 * InstructorDetail detail = new InstructorDetail();
			 * detail.setHobby("sleeping"); detail.setYoutubeChannel("aaa");
			 * session.persist(detail); Instructor i = new Instructor();
			 * i.setFirstName("aaaa"); i.setLastName("bbbbbb"); i.setEmail("ccbb");
			 * i.setInstructorDetail(detail);
			 */
			session.save(new Instructor("John", "Doe", "john@luv2code.com", new
		 InstructorDetail("youtube.com/john", "singing")));

		//	session.persist(i);
			session.getTransaction().commit();
			System.out.println("inserted");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
