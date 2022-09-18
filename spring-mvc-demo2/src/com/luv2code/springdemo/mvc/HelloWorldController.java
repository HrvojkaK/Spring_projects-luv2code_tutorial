package com.luv2code.springdemo.mvc;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller 
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new controller method to read data and add it to the model
	@RequestMapping("/processFormv2") //second, improved version of form reading
	public String upperCase(HttpServletRequest request, Model model) {
		//read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert all letters to uppercase
		theName=theName.toUpperCase();
		
		//create the greeting message
		String result = "Oi! " + theName;
		
		//add message to model
		model.addAttribute("message", result);
		//                     (name, value) pair
		
		return "helloworld";
	}
	
	
	// newer! controller method to read data and add it to the model
		@RequestMapping("/processFormv3") //third, improved version of form reading
		public String upperCaseVersion3(
						@RequestParam("studentName") String theName,
						Model model) {
	
			//convert all letters to uppercase
			theName=theName.toUpperCase();
			
			//create the greeting message
			String result = "v3: Oi! " + theName;
			
			//add message to model
			model.addAttribute("message", result);
			//                     (name, value) pair
			
			return "helloworld";
		}

}
