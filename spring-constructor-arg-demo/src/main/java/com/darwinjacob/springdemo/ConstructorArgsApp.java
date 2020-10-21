package com.darwinjacob.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ConstructorArgsApp {

	public static void main(String[] args) {
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
				
		// create the bean
		Organization organization = (Organization)context.getBean("myorg");
		
		// invoke the company slocan via the bean
		organization.corporateSlogan();
		
		// print organization details
		System.out.println(organization);
		
		// close the application context(container)
		((ClassPathXmlApplicationContext) context).close();		
	}
}
