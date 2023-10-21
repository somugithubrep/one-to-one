package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {
	
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
		
		//start a transcation
		 session.beginTransaction();
		 
		 //get instructor by primary key/id
		 int theId =2;
		 Instructor tempInstructor=
				 session.get(Instructor.class,theId);
		 System.out.println("Found Instructor: " + tempInstructor);
		 
		 //delete the instructors
		 if(tempInstructor !=null) {
	     System.out.println("Deleting: " + tempInstructor);
	     //Note:this will also Delete associated "details" object
	     //because of cascadeType.ALL
		 //
			 
		 session.delete(tempInstructor);
			 }
		 
		 //commit transcation
		 session.getTransaction().commit();
		 
		 System.out.println("done!...");
		 
	 }
	     finally {
		 factory.close();
	 }
   } 
	 
  }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
