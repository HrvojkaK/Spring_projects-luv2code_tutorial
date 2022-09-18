package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //bean with no bean ID specified, so ID defaults to: "fieldyCoach"
public class FieldyCoach implements Coach {

	//inject dependency : Field injection
	@Autowired
	@Qualifier("nightlyMotivationService") //which MotivationService implementation to use (DailyMotSer or NightlyMotServ)-can do without this line only if there is just one MotServ
	private MotivationService motivationService;
	

	@Override
	public String getDailyWorkout() {
		return "Run around the field!";
	}

	@Override
	public String getMotivation() {
		return motivationService.getMotivation();
	}
	

}
