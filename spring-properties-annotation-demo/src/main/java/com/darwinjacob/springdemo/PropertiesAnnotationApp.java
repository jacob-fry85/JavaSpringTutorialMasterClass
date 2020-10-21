package com.darwinjacob.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.darwinjacob.springdemo.domain.Organization;

public class PropertiesAnnotationApp {

	public static void main(String[] args) {
		// create the application context
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PropertyConfig.class);
		Organization org = (Organization) ctx.getBean("myorg");
		System.out.println(org);
		System.out.println("slogan : " + org.corporateSlogan());
		((AnnotationConfigApplicationContext) ctx).close();
	}
}
