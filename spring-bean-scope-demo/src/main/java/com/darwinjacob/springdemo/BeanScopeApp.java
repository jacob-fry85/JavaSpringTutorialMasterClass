package com.darwinjacob.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.darwinjacob.springdemo.domain.Organization;

public class BeanScopeApp {

	public static void main(String[] args) {
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
				
		// create the bean
		Organization organization = (Organization)context.getBean("myorg");
		Organization organization2 = (Organization)context.getBean("myorg");
		organization2.setPostalCode("89898");
		
		// invoke the company slocan via the bean
		System.out.println(organization.corporateSlogan());
		
		// print organization details
		System.out.println(organization);
		System.out.println(organization2);
		if(organization == organization2) {
			System.out.println("organization and organization point to the same instance");
		} else {
			System.out.println("Both org and org 2 are seperate instances");
		}
		
		System.out.println(organization.corporateService());
		
		// close the application context(container)
		((ClassPathXmlApplicationContext) context).close();		
	}
}
