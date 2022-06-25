package com.sg.classroster.ui;

import com.sg.classroster.dto.Student;

public class ClassRosterView {

	//private UserIO io = new UserIOConsoleImpl();
	private UserIO io;
	
	
	public Student getNewStudentInfo() {
	    
		io = new UserIOConsoleImpl();
		
		String studentId = io.readString("Please enter Student ID");
	    String firstName = io.readString("Please enter First Name");
	    String lastName = io.readString("Please enter Last Name");
	    String cohort = io.readString("Please enter Cohort");
	    Student currentStudent = new Student(studentId);
	    currentStudent.setFirstName(firstName);
	    currentStudent.setLastName(lastName);
	    currentStudent.setCohort(cohort);
	    return currentStudent;
	}

	public int printMenuAndGetSelection() {
		// TODO Auto-generated method stub
		return 0;
	}

}
