package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //bean with no bean ID specified, so ID defaults to: "pingpongCoach"
public class PingpongCoach implements Coach {
	
	private MotivationService motivationService;
	
	//default no-arg constructor
	public PingpongCoach(){
		System.out.println("inside pingpong constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Hit the ball!";
	}

	@Override
	public String getMotivation() {
		return motivationService.getMotivation();
	}
	
	//define setter method for dependency injection
	@Autowired
	@Qualifier("dailyMotivationService") //which MotivationService implementation to use (DailyMotSer or NightlyMotServ)
	public void setMotivationService(MotivationService tms) {
		this.motivationService=tms;
		System.out.println("inside pingpong setter");
	}

}
