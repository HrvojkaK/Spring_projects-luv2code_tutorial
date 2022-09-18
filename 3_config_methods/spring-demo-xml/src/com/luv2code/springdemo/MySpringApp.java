package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringApp {

	public static void main(String[] args) {
		// load the spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from spring container
		//Coach theCoach = context.getBean("myCoach", Coach.class);
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getMotivation());
		System.out.println(theCoach.getTeam()); //
		System.out.println(theCoach.getEmailAddress()); //
		
		//close the application context
		context.close();

	}

}
