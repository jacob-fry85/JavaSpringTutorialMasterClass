package com.darwinjacob.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.domain.Organization;

@Service
public class DaoUtils {
	
	private static Logger LOGGER = LoggerFactory.getLogger("Logging Tester");
	public static String createOperation = "CREATE";
	public static String readOperation = "READ";
	public static String updateOperation = "UPDATE";
	public static String deleteOperation = "DELETE";
	public static String cleanOperation = "TRUNCATE";

	public void printOrganizations(List<Organization> orgs, String operation) {
		LOGGER.info("\n*************** printing organizations after " + operation + " operation ***********");
		for (Organization org : orgs) {
			LOGGER.info(org.toString());
		}
	}
	
	public void printOrganization(Organization orgs, String operation) {
		LOGGER.info("\n*************** printing organizations after invoking " + operation + " operation ***********");		
		LOGGER.info(orgs.toString());
	}

	public void printSuccessFailure(String operation, boolean param) {
		if (param)
			LOGGER.info("\nOperation " + operation + " successful");
		else
			LOGGER.info("\nOperation " + operation + " failed");
	}

	public void createSeedData(OrganizationDao dao) {
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

		LOGGER.info("Created " + createCount + " organization");
	}

	public void printOrganizationCount(List<Organization> orgs, String operation) {
		LOGGER.info("\n****************Currently we have " + orgs.size() + " organizations after " + operation
				+ " operations" + "     ");
	}
}
