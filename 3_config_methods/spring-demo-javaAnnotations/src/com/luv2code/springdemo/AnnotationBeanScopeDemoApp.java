package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// this is just to test bean scopes and @PostConstruct and @PreDestroy methods
		
		//load the config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");

		//retrieve bean from spring container
		Coach theCoach = context.getBean("pingpongCoach", Coach.class);
		Coach daCoach = context.getBean("pingpongCoach", Coach.class);
		
		//check if they are the same
		boolean result = (theCoach == daCoach);
		
		System.out.println("Pointing to the same bean: "+result);
		System.out.println("Memory location of theCoach bean: "+theCoach);
		System.out.println("Memory location of daCoach: "+daCoach);
		
		
		
		//testing prototype scope:
				Coach theProtCoach = context.getBean("badmintonCoach", Coach.class);
				Coach daProtCoach = context.getBean("badmintonCoach", Coach.class);
				
				//check if they are the same
				boolean resultProt = (theProtCoach == daProtCoach);
				
				System.out.println("Pointing to the same bean when using prototype scope bean: "+resultProt);
				System.out.println("Memory location of theProtCoach bean: "+theProtCoach);
				System.out.println("Memory location of daProtCoach: "+daProtCoach);
		
				
		// bean lifecycle: testing init and destroy method
				System.out.println("---------");
				Coach theLCoach = context.getBean("badmintonCoach", Coach.class);		
				System.out.println(theLCoach.getDailyWorkout());
				
				
				
		//close the context
		context.close();
		
		
	
	}

}
