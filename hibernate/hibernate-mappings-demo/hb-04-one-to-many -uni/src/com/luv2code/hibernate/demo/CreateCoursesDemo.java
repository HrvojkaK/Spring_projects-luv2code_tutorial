package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			// create and add some courses to the instructor
			Course tempC1 = new Course("Running course");
			Course tempC2 = new Course("Playing the guitar");
			
			tempIns.add(tempC1);
			tempIns.add(tempC2);
			//save courses
			session.save(tempC1);
			session.save(tempC2);
		
	
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
