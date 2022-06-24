package com.mthree.RestfulWebService3;

import java.util.Date;

public class User {

	private int id;
	//@Size(min=3,message="Name must have atleast 3 chars")
	private String name;
	private Date birthday;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getBirtheday() {
		return birthday;
	}


	public void setBirtheday(Date birtheday) {
		this.birthday = birtheday;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
	
}
