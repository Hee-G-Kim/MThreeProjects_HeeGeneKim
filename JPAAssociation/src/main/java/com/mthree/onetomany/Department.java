package com.mthree.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="dept2")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "deptname")
	private String deptName;
	//@OneToMany(targetEntity=Employee.class, mappedBy="dept")//-relationship owner is this employee entity
	@OneToMany(targetEntity=Employee.class,cascade=CascadeType.ALL )
	@JoinColumn(name = "dept_id") //@JoinColumn  and mappedBy Attribute cannot be used together
	//-relationship owner is department entity
	private List<Employee> employees;
	
	public Department() {
	}
	public Department( String deptName) {
	
		this.deptName = deptName;
	}
	public Department(int id, String deptName) {
		this.id = id;
		this.deptName = deptName;
	}
	public Department(int id, String deptName, List<Employee> employees) {
		super();
		this.id = id;
		this.deptName = deptName;
		this.employees = employees;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	
	
	
}
