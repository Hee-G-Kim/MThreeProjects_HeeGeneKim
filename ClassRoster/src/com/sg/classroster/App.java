package com.sg.classroster;

import com.sg.classroster.controller.ClassRosterController;
import com.sg.classroster.dao.ClassRosterAuditDao;
import com.sg.classroster.dao.ClassRosterAuditDaoFileImpl;
import com.sg.classroster.dao.ClassRosterDao;
import com.sg.classroster.dao.ClassRosterDaoFileImpl;
import com.sg.classroster.service.ClassRosterServiceLayer;
import com.sg.classroster.service.ClassRosterServiceLayerImpl;
import com.sg.classroster.ui.ClassRosterView;
import com.sg.classroster.ui.UserIO;
import com.sg.classroster.ui.UserIOConsoleImpl;

public class App {

	public static void main(String[] args) {
		
		//setup no.4
		// Instantiate the UserIO implementation
		UserIO myIo = new UserIOConsoleImpl();
		// Instantiate the View and wire the UserIO implementation into it
		ClassRosterView myView = new ClassRosterView(myIo);
		// Instantiate the DAO
		ClassRosterDao myDao = new ClassRosterDaoFileImpl();
		// Instantiate the Audit DAO
		ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
		// Instantiate the Service Layer and wire the DAO and Audit DAO into it
		ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
		// Instantiate the Controller and wire the Service Layer into it
		ClassRosterController controller = new ClassRosterController(myService, myView);
		// Kick off the Controller
		controller.run();
		
		
		
		/*previous setup 3
		 * UserIO myIo = new UserIOConsoleImpl();
		ClassRosterView myView = new ClassRosterView(myIo);
		ClassRosterDao myDao = new ClassRosterDaoFileImpl();
		ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao);
		ClassRosterController controller = new ClassRosterController(myService, myView);
		controller.run();*/
		
		
		/*previous setup 2*
		UserIO myIo = new UserIOConsoleImpl();
		ClassRosterView myView = new ClassRosterView(myIo);
		ClassRosterDao myDao = new ClassRosterDaoFileImpl();
		ClassRosterController controller = new ClassRosterController(myDao, myView);
		controller.run();
		*/
		/*
		//previous setup 1
		ClassRosterController controller = new ClassRosterController();
		controller.run();  
		*/
		
		
	}

}




























/*public static void main(String[] args) {
	// TODO Auto-generated method stub
	 UserIO userIO = new UserIOConsoleImpl();
     int smallNum = userIO.readInt("Give me a small number :");
     int bigNum = userIO.readInt("Now give me a much bigger number! :");
     if(bigNum < smallNum){
         userIO.print("Hey! " + smallNum +" is BIGGER than " + bigNum);
         userIO.print("I guess I can fix it.");
         int swapNum = bigNum;
         bigNum = smallNum;
         smallNum = swapNum;
     }
     int betweenNum = userIO.readInt("Now give me one in between! : ", smallNum, bigNum);
     userIO.print("I like the number "+betweenNum+"!");} */ 


