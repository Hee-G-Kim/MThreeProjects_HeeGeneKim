package com.sg.vendingmachine.app;

public class App {

	public static void main(String[] args) {
		//setup no.4
		
				// Instantiate the UserIO implementation
				UserIO myIo = new UserIOConsoleImpl();
				// Instantiate the View and wire the UserIO implementation into it
				VendingMachineView myView = new VendingMachineView(myIo);
				// Instantiate the DAO
				VendingMachineDao myDao = new VendingMachineDaoFileImpl();
				// Instantiate the Audit DAO
				VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
				// Instantiate the Service Layer and wire the DAO and Audit DAO into it
				VendingMachineServiceLayer myService = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
				// Instantiate the Controller and wire the Service Layer into it
				VendingMachineController controller = new VendingMachineController(myService, myView);
				// Kick off the Controller
				controller.run();
				

	}

}
