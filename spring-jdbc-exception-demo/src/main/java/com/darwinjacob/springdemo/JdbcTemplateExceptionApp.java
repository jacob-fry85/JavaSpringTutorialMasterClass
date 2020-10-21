package com.darwinjacob.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.darwinjacob.springdemo.dao.OrganizationDao;
import com.darwinjacob.springdemo.daoimpl.OrganizationDaoImpl;
import com.darwinjacob.springdemo.domain.Organization;

public class JdbcTemplateExceptionApp {
	public static void main(String[] args) {
		// creating teh application context
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

		// create the bean
		OrganizationDao orgDao = (OrganizationDaoImpl) ctx.getBean("orgDao");
		List<Organization> orgList = null;

		try {
			orgList = orgDao.getAllOrganizations();
		} catch (BadSqlGrammarException bge) {
			System.out.println("EXCEPTION MESSAGE : " + bge.getMessage());
			System.out.println("EXCEPTION CLASS : " + bge.getClass());
		} catch (DataAccessException dae) {
			System.out.println("EXCEPTION MESSAGE : " + dae.getMessage());
			System.out.println("EXCEPTION CLASS : " + dae.getClass());
		}
		for (Organization org : orgList) {
			System.out.println(org);
		}

		// close the app context
		((ClassPathXmlApplicationContext) ctx).close();
	}
}
