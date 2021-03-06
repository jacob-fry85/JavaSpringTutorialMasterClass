package com.darwinjacob.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.daoimpl.OrganizationDaoImpl;
import com.darwinjacob.springdemo.domain.Organization;

public class JdbcTemplateClassicApp1 {
	public static void main(String[] args) {

		// creating teh application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// create the bean
		OrganizationDao orgDao = (OrganizationDaoImpl) ctx.getBean("orgDao");

		// creating seed data
		DaoUtils.createSeedData(orgDao);

		// List organization
		List<Organization> orgs = orgDao.getAllOrganizations();
		DaoUtils.printOrganizations(orgs, DaoUtils.readOperation);

		// create new organization record
		Organization org = new Organization("General Electric", 1978, "949494", 5776, "Imagination at work");
		boolean isCreated = orgDao.create(org);
		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);
		DaoUtils.printOrganizations(orgDao.getAllOrganizations(), DaoUtils.createOperation);
		DaoUtils.printOrganizationCount(orgDao.getAllOrganizations(), DaoUtils.readOperation);

		// get a single organization
		Organization org2 = orgDao.getOrganization(1);
		DaoUtils.printOrganization(org2, "getOrganization");

		// updating slogan organization
		Organization org3 = orgDao.getOrganization(2);
		org3.setSlogan("Updating Slogan to awesome");
		boolean isUpdated = orgDao.update(org3);
		DaoUtils.printSuccessFailure(DaoUtils.updateOperation, isUpdated);
		DaoUtils.printOrganization(orgDao.getOrganization(2), DaoUtils.updateOperation);

		// deleting organization
		boolean isDeleted = orgDao.delete(orgDao.getOrganization(3));
		DaoUtils.printSuccessFailure(DaoUtils.deleteOperation, isDeleted);
		DaoUtils.printOrganizations(orgDao.getAllOrganizations(), DaoUtils.deleteOperation);

		// clean up
		orgDao.cleanup();
		DaoUtils.printOrganizationCount(orgDao.getAllOrganizations(), DaoUtils.cleanOperation);

		/*
		 * List<Organization> orgList = orgDao.getAllOrganizations(); for (Organization
		 * org : orgList) { System.out.println(org); }
		 */

		// close the app context
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
