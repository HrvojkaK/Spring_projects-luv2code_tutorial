package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student tempStudent = new Student("Po", "Panda","dragon@kungfu.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student obj
			session.save(tempStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			//new stuff:
			// read student obj: (objects are rertrieved from db via primary key
			// find out the key (id):
			System.out.println("Saved student, with an id: "+ tempStudent.getId());
			
			
			// get new session, start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: session.get(Student.class, id)
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("get: " + myStudent);
			
			// commit transaction
			session.getTransaction().commit();
					
		}
		finally {
			factory.close();
		}

	}

}
