package com.darwinjacob.springdemo;

import java.util.ArrayList;
import java.util.List;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.domain.Organization;

public class DaoUtils {

	public static final String createOperation = "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanOperation = "TRUNCATE";

	public static void printOrganizations(List<Organization> orgs, String operation) {
		System.out.println("\n*************** printing organizations after " + operation + " operation ***********");
		for (Organization org : orgs) {
			System.out.println(org);
		}
	}
	
	public static void printOrganization(Organization orgs, String operation) {
		System.out.println("\n*************** printing organizations after invoking " + operation + " operation ***********");		
		System.out.println(orgs);
	}

	public static void printSuccessFailure(String operation, boolean param) {
		if (param)
			System.out.println("\nOperation " + operation + " successful");
		else
			System.out.println("\nOperation " + operation + " failed");
	}

	public static void createSeedData(OrganizationDao dao) {
		Organization org1 = new Organization("Amazon", 1994, "76765", 7500, "Work here, have fun, make history");
		Organization org2 = new Organization("BMW", 1929, "454545", 5581, "We build ultimate Driving machines");
		Organization org3 = new Organization("Google", 1996, "363636", 6500, "Don't be evil");

		List<Organization> orgs = new ArrayList<>();
		orgs.add(0, org1);
		orgs.add(1, org2);
		orgs.add(2, org3);

		int createCount = 0;
		for (Organization org : orgs) {

			boolean isCreated = dao.create(org);
			if (isCreated)
				createCount++;

		}

		System.out.println("Created " + createCount + " organization");
	}

	public static void printOrganizationCount(List<Organization> orgs, String operation) {
		System.out.println("\n****************Currently we have " + orgs.size() + " organizations after " + operation
				+ " operations" + "     ");
	}
}
