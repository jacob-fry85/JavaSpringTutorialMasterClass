package com.darwinjacob.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.darwinjacob.springdemo.domain.Department;
import com.darwinjacob.springdemo.domain.Organization;

public class DIConstructorApp {

	public static void main(String[] args) {
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
				
		// create the bean
		Organization organization = (Organization)context.getBean("myorg");
		
		// invoke the company slocan via the bean
		System.out.println(organization.corporateSlogan());
	
		
		Department department = (Department)context.getBean("myHrd");
		System.out.println(department.hiringStatus(5500));
		
		// close the application context(container)
		((ClassPathXmlApplicationContext) context).close();		
	}
}
