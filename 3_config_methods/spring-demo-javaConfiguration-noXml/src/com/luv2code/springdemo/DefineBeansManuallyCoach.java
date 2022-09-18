package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class DefineBeansManuallyCoach implements Coach {

	//define field for dependency injection
	private MotivationService motivationService;
	
	//inject dependency via constructor injection
	public DefineBeansManuallyCoach(MotivationService mS) {
		this.motivationService = mS;
	}
	
	//define fields to inject values from the .properties file
	@Value("${foo.email}")
	private String email; 

	@Value("${foo.team}")
	public String team;//public -so I don't need two getters
	
	
	
	@Override
	public String getDailyWorkout() {
		return "Go define a bean manually in Config.java class! Anotations & ComponentScan are for losers.";
	}

	@Override
	public String getMotivation() {
		return motivationService.getMotivation();
	}

	public String getEmail() {
		return email;
	}


	

}
