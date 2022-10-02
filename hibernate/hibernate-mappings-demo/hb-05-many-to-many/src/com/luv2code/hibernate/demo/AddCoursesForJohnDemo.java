package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForJohnDemo {

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
			
			// get the student John from db (John has id=1)
			int studentId = 1;
			Student tempS = session.get(Student.class, studentId);
			
			// create more courses
			Course tempC1 = new Course("Solving problems");
			Course tempC2 = new Course("Yelling quietly!");
						
			//add John to those courses
			tempC1.addStudent(tempS);
			tempC2.addStudent(tempS);
			
			// save the courses
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
