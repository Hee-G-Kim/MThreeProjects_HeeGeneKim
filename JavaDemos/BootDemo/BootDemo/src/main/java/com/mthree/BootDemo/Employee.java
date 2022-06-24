package com.mthree.BootDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value ="Employee")//like saying bean id=..
public class Employee {

	@Value(value ="e1")
	private int id;
	@Value(value ="Hee")
	private String name;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}
