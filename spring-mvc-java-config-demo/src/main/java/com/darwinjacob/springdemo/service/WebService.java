package com.darwinjacob.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WebService implements GenericWelcomeService {
	public List<String> getWelcomeMessage(String name) {
		List<String> myWelcomeMessage = new ArrayList<String>();
		
		//add data to the list
		myWelcomeMessage.add("Hello ");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", welcome to the Spring course!");
				
		return myWelcomeMessage;
	}
}
