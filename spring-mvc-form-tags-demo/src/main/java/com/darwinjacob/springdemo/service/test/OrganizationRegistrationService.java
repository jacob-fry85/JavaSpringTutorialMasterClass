package com.darwinjacob.springdemo.service.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrganizationRegistrationService {
	
	@Value("#{serviceLengthOptions}")
	private Map<String,String> serviceLengthList;
	
	public Map<String, String> populateTurnover() {
		Map<String, String> turnover = new LinkedHashMap<>();
		turnover.put("none", "------SELECT-------");
		turnover.put("1000", "Less than $1,000");
		turnover.put("10000", "Less than $10,000");
		turnover.put("100000", "Less than $100,000");
		return turnover;
	}

	public Map<String, String> populateTypes(){
		Map<String, String> types = new LinkedHashMap<>();
		types.put("gov", "government");
		types.put("semigov", "Semi Government");
		types.put("private", "Private");
		return types;
	}
	
	public Map<String, String> populateServiceLength() {
		return new TreeMap<String, String> (serviceLengthList);
	}
	
	public Map<String, String> populateRegisteredPreviously() {
		Map<String, String> registeredPreviously = new LinkedHashMap<>();
		registeredPreviously.put("true", "Yes");
		registeredPreviously.put("false", "No");
		return registeredPreviously;	
	}
	
	public Map<String, String> populateOptionalServices() {
		Map<String, String> optionalServices = new LinkedHashMap<>();
		optionalServices.put("emailService", "Mailing List");
		optionalServices.put("promotionalService", "Promotional Emails");
		optionalServices.put("newsLetterService", "Weekly Newsletter");
		return optionalServices;	
	}
	
	public Map<String, String> populatePremiumServices() {
		Map<String, String> premiumServices = new LinkedHashMap<>();
		premiumServices.put("directoryService", "Directory");
		premiumServices.put("revenueReportService", "Revenue Reports");
		premiumServices.put("revenueAnalyticsService", "Revenue Analytics");
		return premiumServices;	
	}
	
	public Map<String, String> populateEmployeeStrength() {
		Map<String, String> employeeStrength = new LinkedHashMap<>();
		employeeStrength.put("small", "Less than 100");
		employeeStrength.put("medium", "Greater than or equal to 100 but less than 1000");
		employeeStrength.put("large", "1000 or more");
		return employeeStrength;	
	}
}
