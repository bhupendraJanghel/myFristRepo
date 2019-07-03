package com.Bhuppi.maven_hibernate_one_to_many.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Bhuppi.maven_hibernate_one_to_many.entity.Course;
import com.Bhuppi.maven_hibernate_one_to_many.entity.Instructor;
import com.Bhuppi.maven_hibernate_one_to_many.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.openSession();
		
		try {			
			
			// create the objects			
			Instructor tempInstructor = 
					new Instructor("Susan", "Public", "susan.public@luv2code.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.youtube.com",
							"Video Games");		
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);					
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





