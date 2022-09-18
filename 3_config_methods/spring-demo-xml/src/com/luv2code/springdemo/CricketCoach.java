package com.luv2code.springdemo;

public class CricketCoach implements Coach {

	//define private fields for dependency
	private MotivationService motivationService;
	
	//define new fields for email address and team
	private String emailAddress;
	private String team;
	
	//setter method for dependency injection
	public void setMotivationService(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	//getter and setter methods for email and team (will inject values from xml file)
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	
	
	@Override
	public String getDailyWorkout() {
		return "Practice being a cricket!";
	}	
	
	@Override
	public String getMotivation() {
		return motivationService.getMotivation();
	}

}
