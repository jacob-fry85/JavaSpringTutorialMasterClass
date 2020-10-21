package com.darwinjacob.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.dao.OrganizationDaoImpl;
import com.darwinjacob.springdemo.domain.Organization;

public class JdbcTemplateClassicApp1 {
	public static void main(String[] args) {
		// creating teh application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// create the bean
		OrganizationDao orgDao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		List<Organization> orgList = orgDao.getAllOrganizations();

		for (Organization org : orgList) {
			System.out.println(org);
		}

		// close the app context
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
