package com.mthree.onetoone;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addr1")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
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
