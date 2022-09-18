package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class NightlyMotivationService implements MotivationService {

	@Override
	public String getMotivation() {
		return "You can do it also in the night!";
	}

}
