package com.darwinjacob.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCAppl {

	public static void main(String[] args) {
		// create the application context
		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
		
		// create the bean
		Organization organization = (Organization)context.getBean("myorg");
		
		// invoke the company slocan via the bean
		organization.corporateSlogan();
		
		// close the application context(container)
		((FileSystemXmlApplicationContext) context).close();
	}

}
