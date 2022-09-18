package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DailyMotivationService implements MotivationService {

	@Override
	public String getMotivation() {
		return "You can do it!";
	}

}
