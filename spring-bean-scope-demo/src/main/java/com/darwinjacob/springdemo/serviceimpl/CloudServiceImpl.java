package com.darwinjacob.springdemo.serviceimpl;

import java.util.Random;

import com.darwinjacob.springdemo.service.BusinessService;

public class CloudServiceImpl implements BusinessService{

	@Override
	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization, " + companyName +
				" offers world class Cloud computing Infrastructure. " +
				"\nThe annual income exceeds " + random.nextInt(revenue) + "dollars. ";
		return service;
	}

}
