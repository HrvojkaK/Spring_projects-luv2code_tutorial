package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	//define private fields for dependency
		private MotivationService motivationService;
		
		//constructor for dependency injection
		public TrackCoach(MotivationService motivationService) {
			this.motivationService = motivationService;
		}

	@Override
	public String getDailyWorkout() {
		return "Run like you've being chased by armed bunnies!";
	}

	@Override
	public String getMotivation() {
		//use helper class MotivationService
		return motivationService.getMotivation();
	}

}
