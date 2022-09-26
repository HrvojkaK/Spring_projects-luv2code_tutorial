package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			
			// get a session, start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// get student with the id=studentId: session.get(Student.class, id)
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("got: " + myStudent);
			System.out.println("updating student...");
			
			// update the student myStudent:
			myStudent.setFirstName("Newname");
			
			
			// update email for ALL students:
			session.createQuery("update Student set email='newemail@fu.com'").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
					
		}
		finally {
			factory.close();
		}

	}

}
