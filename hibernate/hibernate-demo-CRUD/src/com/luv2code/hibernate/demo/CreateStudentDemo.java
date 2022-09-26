package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save Java obj
			//create a student object
			System.out.println("making new student obj...");
			Student tempStudent = new Student("Paul", "Atreides","jihad@arrakis.com");
			Student tempStudent2 = new Student("Alia", "Atreides","alia@arrakis.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student obj
			session.save(tempStudent);
			session.save(tempStudent2);
			
			//commit transaction
			session.getTransaction().commit();
					
		}
		finally {
			factory.close();
		}

	}

}
