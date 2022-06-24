package com.mthree.BootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication//@SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration.
public class BootDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BootDemoApplication.class, args);- this is the appicarion contex
		ApplicationContext context= SpringApplication.run(BootDemoApplication.class, args);
		Employee emp= context.getBean("e1",Employee.class);
		
		System.out.println(emp);
	}

}
