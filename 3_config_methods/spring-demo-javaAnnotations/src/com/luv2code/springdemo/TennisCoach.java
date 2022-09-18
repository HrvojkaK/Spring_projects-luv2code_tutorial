package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myTenisCoach") //bean with ID "myTenisCoach"
public class TennisCoach implements Coach {

	private MotivationService motivationService;
	
	//constructor for dependency injection:
	@Autowired //Spring will scan for a component that implements MotServ (here DailyMotServ) and inject-no need for xml configuring
	                                    //which MotivationService implementation to use (DailyMotSer or NightlyMotServ)
	public TennisCoach(@Qualifier("dailyMotivationService") MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Play some tennis";
	}

	@Override
	public String getMotivation() {
		return motivationService.getMotivation();
	}

}
