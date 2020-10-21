package com.darwinjacob.springiocdemochallenge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCAppChallenge2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-challenge2.xml");
		
		City city = (City) context.getBean("myCity");
		
		city.cityName();
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
