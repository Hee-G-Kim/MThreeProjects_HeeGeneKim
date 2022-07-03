package com.sg.classroster.dto;

import java.util.Objects;

public class Student {

	private String firstName;
	private String lastName;
	private String studentId;
	// Programming Language + cohort month/year
	private String cohort;

	public Student() {
		
	}
	
	public Student(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cohort, firstName, lastName, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(cohort, other.cohort) 
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) 
				&& Objects.equals(studentId, other.studentId);
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName 
				+ ", studentId=" + studentId + ", cohort=" + cohort + "]";
	}

	
}
