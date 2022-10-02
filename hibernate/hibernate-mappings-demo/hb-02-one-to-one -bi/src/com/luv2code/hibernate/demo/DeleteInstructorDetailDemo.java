package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
						
			//start a transaction
			session.beginTransaction();
			

			// get instructor detail obj
			int theId = 1;
			InstructorDetail tempInDet = session.get(InstructorDetail.class, theId);
			
			// delete instructor detail; but first need to remove the associated object (I don't want a cascade delete)
			//break bi-directional link:
			tempInDet.getInstructor().setInstructorDetail(null);
			session.delete(tempInDet); // this would also delete the corresponding Instructor (if CascadeType.ALL!)
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done.");
					
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
