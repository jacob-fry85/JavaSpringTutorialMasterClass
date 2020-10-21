package com.darwinjacob.springdemo.serviceimpl;

import java.util.Random;

import com.darwinjacob.springdemo.service.RecruitmentService;

public class ReferalRecruitmentServiceImpl implements RecruitmentService {

	@Override
	public String recruitEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName + " hired " +
					random.nextInt(numberOfRecruitments) + " employees " +
				"which were references to the company by employees.";
			
		return hiringFacts;
	}

}
