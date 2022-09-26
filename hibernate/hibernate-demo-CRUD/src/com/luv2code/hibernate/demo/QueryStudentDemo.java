package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {

			//start a transaction
			session.beginTransaction();
			
			// query the students
			List<Student> theStudents = session.createQuery("from Student").list();
			// display students
			for(Student st : theStudents) {System.out.println(st);}
			
			//query students with last name Atreides
			theStudents = session.createQuery("from Student s where s.lastName='Atreides'").list();
			// display
			System.out.println("students with last name \"Atreides\":");
			for(Student st : theStudents) {System.out.println(st);}
			
			//query students with last name Atreides OR first name Po
			theStudents = 
			session.createQuery("from Student s where s.lastName='Atreides' OR s.firstName='Po'").list();
			// display
			System.out.println("students with last name \"Atreides\" OR first name 'Po':");
			for(Student st : theStudents) {System.out.println(st);}
			
			//query students with email ending with "fu.com" ( LIKE '%fu.com' )
			theStudents = 
			session.createQuery("from Student s where s.email LIKE '%fu.com'").list();
			// display
			System.out.println("students with email ending with 'fu.com':");
			for(Student st : theStudents) {System.out.println(st);}
			
			//commit transaction
			session.getTransaction().commit();
					
		}
		finally {
			factory.close();
		}

	}

}
