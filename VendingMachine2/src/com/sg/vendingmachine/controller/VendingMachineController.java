package com.sg.vendingmachine.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;
import com.sg.vendingmachine.service.ChangeDistributor;
import com.sg.vendingmachine.service.ChangeDistributor.Unit;
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
			
			try {
				while (keepGoing) {

					
					  io.print("Main Menu"); 
					  listItems();
					  char answer= io.readChar("Do you wish to place an order(y/n)?");
					if(answer=='y' || answer=='Y' ) {
						String menuSelection= Integer.toString(io.readInt("Select the item you want to "
								+ "order: "));
						//int qty=io.readInt("enter quantity: ");
						//orderItem(menuSelection, qty);
						BigDecimal amountPayed= io.readBigDecimal("Enter amount payed: ");
						orderItem(menuSelection , amountPayed);
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
		
//		private void orderItem(int menuSelection, int qty) {
//			//To do
//			//order Arraylist
//		};
		private void orderItem(String menuSelection, BigDecimal monies) throws VendingMachinePersistenceException {
			//
			removeItem(menuSelection, monies);
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

		private void removeItem(String menuSelection, BigDecimal amountPayed) throws 
												VendingMachinePersistenceException {
			//view.displayRemoveItemBanner();
			//String itemId = view.getItemIdChoice();
						
			Item itemRemoved= service.removeItem(menuSelection);
			if (Objects.nonNull(itemRemoved)) {
				ChangeDistributor cd= new ChangeDistributor();
				BigDecimal price = BigDecimal.valueOf(itemRemoved.getPrice());
				Map<Unit, Integer> changeDue = cd.getUnit(amountPayed, price );
				for(Unit unit : changeDue.keySet()) {
		            System.out.println("Return " + unit + " : "+ changeDue.get(unit));
		        }
				view.displayItemBoughtSuccessBanner(itemRemoved.getName());
			}
			
		}

		private void unknownCommand() {
			view.displayUnknownCommandBanner();
		}

		private void exitMessage() {
			view.displayExitBanner();
		}
}
