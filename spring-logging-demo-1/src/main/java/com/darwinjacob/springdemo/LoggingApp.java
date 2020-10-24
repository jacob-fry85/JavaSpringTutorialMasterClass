package com.darwinjacob.springdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.daoimpl.OrganizationDaoImpl;
import com.darwinjacob.springdemo.domain.Organization;

@Component
public class LoggingApp {

	@Autowired
	private OrganizationDao orgDao;

	@Autowired
	private DaoUtils daoUtils;

	private void actionMethod() {		
			orgDao.cleanup();
			// creating seed data
			daoUtils.createSeedData(orgDao);

			// List organization
			List<Organization> orgs = orgDao.getAllOrganizations();
			daoUtils.printOrganizations(orgs, daoUtils.readOperation);

			// create new organization record
			Organization org = new Organization("General Electric", 1978, "949494", 5776, "Imagination at work");
			boolean isCreated = orgDao.create(org);
			daoUtils.printSuccessFailure(daoUtils.createOperation, isCreated);
			daoUtils.printOrganizations(orgDao.getAllOrganizations(), daoUtils.createOperation);
			daoUtils.printOrganizationCount(orgDao.getAllOrganizations(), daoUtils.readOperation);

			// get a single organization
			Organization org2 = orgDao.getOrganization(1);
			daoUtils.printOrganization(org2, "getOrganization");

			// updating slogan organization
			Organization org3 = orgDao.getOrganization(2);
			org3.setSlogan("Updating Slogan to awesome");
			boolean isUpdated = orgDao.update(org3);
			daoUtils.printSuccessFailure(daoUtils.updateOperation, isUpdated);
			daoUtils.printOrganization(orgDao.getOrganization(2), daoUtils.updateOperation);

			// deleting organization
			boolean isDeleted = orgDao.delete(orgDao.getOrganization(3));
			daoUtils.printSuccessFailure(daoUtils.deleteOperation, isDeleted);
			daoUtils.printOrganizations(orgDao.getAllOrganizations(), daoUtils.deleteOperation);

			// clean up
			orgDao.cleanup();
			daoUtils.printOrganizationCount(orgDao.getAllOrganizations(), daoUtils.cleanOperation);			

	}

	public static void main(String[] args) {
		// creating thh application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");
		LoggingApp mainApp = ctx.getBean(LoggingApp.class);
		mainApp.actionMethod();
		
		
		// close the app context
		((ClassPathXmlApplicationContext)ctx).close();
		
		// create the bean
		//OrganizationDao orgDao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		}
		
}
