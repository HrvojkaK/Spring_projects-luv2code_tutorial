package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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

			//start a transaction
			session.beginTransaction();
			
			// get instructor from db
			Instructor tempIns = session.get(Instructor.class, 1); //id=1
			
			// get the courses from this instructor, print it
			System.out.println("Instructor "+tempIns+" has these courses: "+tempIns.getCourses());
		
	
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
