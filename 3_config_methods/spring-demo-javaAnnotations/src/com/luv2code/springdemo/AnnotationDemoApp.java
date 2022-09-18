package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("myTenisCoach", Coach.class);
		Coach pingCoach = context.getBean("pingpongCoach", Coach.class); //default bean ID is Class name with first letter lowered
		Coach badmCoach = context.getBean("badmintonCoach", Coach.class); //default bean ID...
		Coach fieldCoach = context.getBean("fieldyCoach", Coach.class); //default bean ID...
		
		// call method on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getMotivation());
		System.out.println(pingCoach.getDailyWorkout());
		System.out.println(pingCoach.getMotivation());
		System.out.println(badmCoach.getDailyWorkout());
		System.out.println(badmCoach.getMotivation());
		System.out.println(fieldCoach.getDailyWorkout());
		System.out.println(fieldCoach.getMotivation());
		
		// close the context
		context.close();

	}

}
