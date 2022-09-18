package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//no @ComponentScan-will define beans here manually
@PropertySource("classpath:DefineBeansManually-sport.properties") //to load .properties file
public class DefineBeansManuallySportConfig {
	
	//define bean for DefineBeansManuallyMotivationService
	@Bean
	public MotivationService methodNameIsTheBeanID() {
		return new DefineBeansManuallyMotivationService();
	}
	
	// define bean for DefineBeansManuallyCoach and inject dependencies
	@Bean
	public Coach coachBeanName() {
		return new DefineBeansManuallyCoach(methodNameIsTheBeanID());
	}

}
