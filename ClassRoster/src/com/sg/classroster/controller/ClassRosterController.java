package com.sg.classroster.controller;

import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;

public class ClassRosterController {
	
	private ClassRosterView view = new ClassRosterView();

	private UserIO io = new UserIOConsoleImpl();
	
	public void run() {
		
		boolean keepGoing = true;
		int menuSelection = 0;
		while (keepGoing) {
		io.print("Main Menu");
		io.print("1. List Student IDs");
		io.print("2. Create New Student");
		io.print("3. View a Student");
		io.print("4. Remove a Student");
		io.print("5. Exit");
		
		menuSelection = io.readInt("Please select from the"
		+ " above choices.", 1, 5);
		
		switch (menuSelection) {
			case 1:
				io.print(">");
				io.print("LIST STUDENTS");
				io.print("====================");
				io.print(" ");
			break;
			case 2:
				io.print(">");
				io.print("CREATE STUDENT");
				io.print("====================");
				io.print(" ");
			break;
			case 3:
				io.print(">");
				io.print("VIEW STUDENT");
				io.print("====================");
				io.print(" ");
			break;
			case 4:
				io.print(">");
				io.print("REMOVE STUDENT");
				io.print("====================");
				io.print(" ");
			break;
			case 5:
			keepGoing = false;
			break;
			default:
				io.print(">");
				io.print("UNKNOWN COMMAND");
				io.print("====================");
				io.print(" ");
			}
			
		}
		
		io.print("GOOD BYE");
		
	}
		
		
	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
		}
	
	
	
	
	
}
