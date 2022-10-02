package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			// create objects
			Instructor tempIns = new Instructor("Mike","Mikey","mike@mikey.com");
			InstructorDetail tempInsDetail = new InstructorDetail("www.example","running");
			
			//associate the objects
			tempIns.setInstructorDetail(tempInsDetail);
			
			//start a transaction
			session.beginTransaction();

			// save the instructor
			session.save(tempIns); //this will also save tempInsDetail 
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done.");
					
		}
		finally {
			session.close();
			factory.close();
		}

	}

}
