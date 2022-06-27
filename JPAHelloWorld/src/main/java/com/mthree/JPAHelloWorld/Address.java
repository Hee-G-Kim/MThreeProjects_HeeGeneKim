package com.mthree.JPAHelloWorld;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "city")
	private String city;
	@Column(name = "postcode")
	private int zip;
	
	public Address() {
		super();
	}

	public Address(String city, int zip) {
		super();
		this.city = city;
		this.zip = zip;
	}
	
	
	
	
}
