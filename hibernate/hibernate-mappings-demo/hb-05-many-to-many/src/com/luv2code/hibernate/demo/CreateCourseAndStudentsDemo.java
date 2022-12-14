package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create a session
		Session session = factory.getCurrentSession();
		
		try {

			//start a transaction
			session.beginTransaction();
			
			//create a course
			Course tempC = new Course("Typing course");
			
			//save the course
		    session.save(tempC);
	
		    // create students
		    Student tempS1 = new Student("John","Walker","john@email.com");
		    Student tempS2 = new Student("Joe","Johnny","joe@email.com");
		    // add them to the course
		    tempC.addStudent(tempS1);
		    tempC.addStudent(tempS2);
		    
		    // save the students
		    session.save(tempS1);
		    session.save(tempS2);
		    
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
