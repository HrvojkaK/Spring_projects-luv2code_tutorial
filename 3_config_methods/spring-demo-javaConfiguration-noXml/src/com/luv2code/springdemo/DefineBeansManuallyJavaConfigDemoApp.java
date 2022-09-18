package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DefineBeansManuallyJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DefineBeansManuallySportConfig.class);
		
		// get the bean from spring container
		DefineBeansManuallyCoach theCoach = context.getBean("coachBeanName", DefineBeansManuallyCoach.class);
		
		
		// call method on bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getMotivation());
		System.out.println(theCoach.team); //this is a public var
		System.out.println(theCoach.getEmail()); //this is private - access through getter
		
		
		// close the context
		context.close();

	}

}
