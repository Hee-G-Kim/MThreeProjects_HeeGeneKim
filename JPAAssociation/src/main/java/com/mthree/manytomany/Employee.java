package com.mthree.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "emp3")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "firstname")
	private String fname;
	@Column(name = "lastname")
	private String lname;
//	@OneToMany(cascade= CascadeType.ALL)
//	@ManyToOne
//	private Department dept;
	@ManyToMany(targetEntity=TechSkill.class)
	private List<TechSkill> skills;
	
	public Employee(){
		
	}

	public List<TechSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<TechSkill> skills) {
		this.skills = skills;
	}

	public Employee( String fname, String lname) {
		this.fname = fname;
		this.lname = lname;

	}
	public Employee(int id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

}
