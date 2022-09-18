package com.luv2code.springdemo;

public class DefineBeansManuallyMotivationService implements MotivationService {

	@Override
	public String getMotivation() {
		return "C'mon, you can NOT use ComponentScan!";
	}

}
