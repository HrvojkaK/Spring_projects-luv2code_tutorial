package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //bean with no bean ID specified, so ID defaults to: "badmintonCoach"
@Scope("prototype")//new obj is created every time I request this bean(make new instance) -default scope is singleton(only one instance of class is ever made)
public class BadmintonCoach implements Coach {

	private MotivationService motivationService;
	
	//default no-arg constructor
	public BadmintonCoach(){}

	@Override
	public String getDailyWorkout() {
		return "Hit the ball thingy!";
	}

	@Override
	public String getMotivation() {
		return motivationService.getMotivation();
	}
	
	//define *any* method for dependency injection
	@Autowired
	@Qualifier("dailyMotivationService") //which MotivationService implementation to use (DailyMotSer or NightlyMotServ)
	public void randomMethodName(MotivationService tms) {
		this.motivationService=tms;
	}
	
	
	
	
	//playing with bean lifecycle:
	//
	// add init method (method gets executed when bean is created)
	@PostConstruct
	public void doStartupStuff() {
		System.out.println("inside badminton coach init");
	}
	
	//add a destroy method (gets executed before bean is destroyed)
	//if bean is of "prototype" scope, Spring won't call PreDestry method (bean needs to be singleton)
	@PreDestroy
	public void doCleanupStuff() {
		System.out.println("inside badminton coach destroy");
	}


}
