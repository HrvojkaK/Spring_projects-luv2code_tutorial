package com.luv2code.springdemo;


public class SwimmingCoach implements Coach{
	
	//define private fields for dependency
	private MotivationService motivationService;
	
	//constructor for dependency injection
	public SwimmingCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	//default no-arg constructor
	public SwimmingCoach() {}
	
	
	@Override
	public String getDailyWorkout() {
		return "Swim a lot!";
	}

	@Override
	public String getMotivation() {
		//use helper class MotivationService
		return motivationService.getMotivation();
	}

}
