package com.darwinjacob.springiocdemochallenge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class IOCAppChallenge1 {
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("beans-challenge1.xml");
		
		City city = (City) context.getBean("myCity");
		
		city.cityName();
		
		((FileSystemXmlApplicationContext)context).close();
	}
}
