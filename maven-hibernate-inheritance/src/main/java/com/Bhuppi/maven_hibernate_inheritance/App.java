package com.Bhuppi.maven_hibernate_inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
       
    	
    	try {
    		
    		SessionFactory factory =new Configuration().configure("hibernate.cfg.xml")
    				.addAnnotatedClass(Car.class).addAnnotatedClass(Automatic.class).buildSessionFactory();
    		
    		Session session=factory.openSession();
    		session.getTransaction().begin();
//  		Manual c1=new Manual();
//    		c1.setCarColor("grey");
//    		c1.setMakeYear("2019");
//    		c1.setIsAutomatic("false");
//    		session.save(c1);
//    		session.getTransaction().commit();
//    		System.out.println("done..!");
//    		
    		Automatic c2=new Automatic();
    		c2.setCarColor("red");
    		c2.setIsAutomatic("true");
    		c2.setMakeYear("2009");
    				
    		session.save(c2);
    		session.getTransaction().commit();
    		System.out.println("done..!");
    		
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    }
}
