package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// now delete the student myStudent:
			session.delete(myStudent);
			
			
			// or, delete a student 'on the fly' (without retrieving it from db):
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// commit transaction
			session.getTransaction().commit();
					
		}
		finally {
			factory.close();
		}

	}

}
