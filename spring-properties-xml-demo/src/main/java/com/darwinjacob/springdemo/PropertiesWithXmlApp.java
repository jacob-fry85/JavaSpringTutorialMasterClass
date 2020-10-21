package com.darwinjacob.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.darwinjacob.springdemo.domain.Organization;
import com.darwinjacob.springdemo.domain.promotion.TradeFair;

public class PropertiesWithXmlApp {

	public static void main(String[] args) {
		// create the application context
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
				
		TradeFair tradeFair = (TradeFair) context.getBean("myfair");
		System.out.println(tradeFair.specialPromotionalPricing());
		
		Organization org = (Organization) context.getBean("myorg");
		System.out.println(org);
		// close the application context(container)
		((ClassPathXmlApplicationContext) context).close();		
	}
}
