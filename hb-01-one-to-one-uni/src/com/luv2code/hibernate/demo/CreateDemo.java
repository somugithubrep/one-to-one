package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {
	
	private static final SharedSessionContract factory = null;

	public static void main(String[] args) {
	
		
		//create session factory
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Instructor.class)
				                .addAnnotatedClass(InstructorDetail.class)
				                .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();

	try {
		//create the objects
		
		Instructor tempInstructor =
				new Instructor("chad","Darby","darby@luv2code.com");
		
		InstructorDetail tempInstructorDetail=
				new InstructorDetail("http://www.luv2code.com/youtube",
						"luv 2 code!!!");
		
		
		/*Instructor tempInstructor =
				new Instructor("sowmya","char","sowmya@luv2code.com");
		
		InstructorDetail tempInstructorDetail=
				new InstructorDetail("http://www.youtube.com",
						"Guithub!!!");
						*/
		
		//associate the objects
		tempInstructor.setInstructordetail(tempInstructorDetail);
		
		 //start a transcation
		 session.beginTransaction();
		 
		 //save the instructor
		 //
		 //Note:tis will also save the details object
		 //because of cascadeType.ALL
		 System.out.println("Saving instructor: " + tempInstructor);
		 session.save(tempInstructor);
		 
	
		 //commit transcation
		 session.getTransaction().commit();
		 
		 System.out.println("done!...");
		 
	 }
	 finally {
		 factory.close();
	 }
} 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
