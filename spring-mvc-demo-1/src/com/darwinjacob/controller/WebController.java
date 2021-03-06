package com.darwinjacob.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.darwinjacob.service.GenericWelcomeService;
import com.darwinjacob.service.WebService;

@Controller
public class WebController {
	
	@Autowired
	private GenericWelcomeService welcomeService;
	
	@RequestMapping("/")
	// http://localhost:8080/spring-mvc-demo-1/
	public String welcome(Model model) {
		
		//1. Retrieving the processed data
		List<String> welcomeMessage = welcomeService.getWelcomeMessage("Darwin Tirta");
		
		//2. add data to the model
		model.addAttribute("myWelcomeMessage", welcomeMessage);
		
		//3. return logical view name
		return "welcome";
	}
}
