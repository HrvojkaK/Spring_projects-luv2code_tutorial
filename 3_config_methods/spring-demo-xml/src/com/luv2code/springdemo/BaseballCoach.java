package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//define private fields for dependency
		private MotivationService motivationService;
		
		//constructor for dependency injection
		public BaseballCoach(MotivationService motivationService) {
			this.motivationService = motivationService;
		}
	
	@Override
	public String getDailyWorkout() {
		return "Practice batting for 1 hour";
	}

	@Override
	public String getMotivation() {
		//use helper class MotivationService
		return motivationService.getMotivation();
	}
	
	// add init method (method gets executed when bean is created)
	public void doStartupStuff() {
		System.out.println("inside baseball coach init");
	}
	
	//add a destroy method (gets executed before bean is destroyed)
	public void doCleanupStuff() {
		System.out.println("inside baseball coach destroy");
	}

}
