package com.darwinjacob.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BeanFactoryApp {

	public static void main(String[] args) {
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
				
		// create the bean
		Organization org = (Organization)context.getBean("myorg");
		Organization org2 = (Organization)context.getBean("myorg2");
		
		// invoke the company slocan via the bean
		//organization.corporateSlogan();
		
		// print organization details
		System.out.println(org);
		System.out.println(org2);
		
		// close the application context(container)
		((ClassPathXmlApplicationContext) context).close();		
	}
}
