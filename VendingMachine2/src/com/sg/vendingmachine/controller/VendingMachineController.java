package com.sg.vendingmachine.controller;

import java.util.List;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.VendingMachineDataValidationException;
import com.sg.vendingmachine.service.VendingMachineDuplicateIdException;
import com.sg.vendingmachine.service.VendingMachineServiceLayer;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;

public class VendingMachineController {
	// private VendingMachineView view = new VendingMachineView();
		// private VendingMachineDao dao = new VendingMachineDaoFileImpl();
		private VendingMachineView view;
		//private VendingMachineDao dao;
		private VendingMachineServiceLayer service;

		public VendingMachineController(VendingMachineServiceLayer
				service, VendingMachineView view) {
				this.service = service;
				this.view = view;
				}

		private UserIO io = new UserIOConsoleImpl();

		public void run() {

			boolean keepGoing = true;
			int menuSelection = 0;

			try {
				while (keepGoing) {

					
					  io.print("Main Menu"); 
					  listItems();
					  char answer= io.readChar("Do you wish to place an order(y/n)?");
					if(answer=='y' || answer=='Y' ) {
						menuSelection= io.readInt("Select the item you want to order: ");
						int qty=io.readInt("enter quantity: ");
						orderItem(menuSelection, qty);
					}
					else if(answer == 'n'|| answer =='N'){
						break;
					}else {
						io.print("Enter only y or n");
					}
					 
					//menuSelection = getMenuSelection();
				}
				exitMessage();
				// io.print("GOOD BYE");
			} catch (VendingMachinePersistenceException e) {
				// e.printStackTrace();
				view.displayErrorMessage(e.getMessage());
			}

		}

		// ----------------------------------
		private int getMenuSelection() {
			return view.printMenuAndGetSelection();
		}
		
		private void orderItem(int menuSelection, int qty) {
			//To do
			//order Arraylist
		};

		private void listItems() throws VendingMachinePersistenceException {
			view.displayDisplayAllBanner();
			List<Item> itemList = service.getAllItems();
			view.displayItemList(itemList);
		}
		
		

		private void viewItem() throws VendingMachinePersistenceException {
			view.displayDisplayItemBanner();
			String itemId = view.getItemIdChoice();
			Item item = service.getItem(itemId);
			view.displayItem(item);
		}

		private void removeItem() throws VendingMachinePersistenceException {
			view.displayRemoveItemBanner();
			String itemId = view.getItemIdChoice();
			service.removeItem(itemId);
			view.displayRemoveSuccessBanner();
		}

		private void unknownCommand() {
			view.displayUnknownCommandBanner();
		}

		private void exitMessage() {
			view.displayExitBanner();
		}
}
