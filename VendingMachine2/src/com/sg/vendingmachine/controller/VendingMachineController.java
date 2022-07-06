package com.sg.vendingmachine.controller;

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
					  
					  //io.print("1. List Student IDs");
					  io.print("1. List Item Names");
					  io.print("2. Create New Item"); 
					  io.print("3. View a Item");
					  
					  //io.print("4. Remove a Student"); 
					  io.print("4. Remove a Item"); 
					  io.print("5. Exit");
					

					 menuSelection = io.readInt("Please select from the" +
					 " above choices.", 1, 5);
					//menuSelection = getMenuSelection();

					switch (menuSelection) {
					case 1:
						io.print(">");
						io.print("LISTING ITEMS");
						listItems();
					case 2:
						io.print(">");
						io.print("CREATE ITEM");
						createItem();

						break;
					case 3:
						io.print(">");
						io.print("VIEW ITEM");
						viewItem();
						break;

					case 4:
						io.print(">");
						io.print("REMOVE ITEM");
						removeItem();

						break;
					case 5:
						keepGoing = false;
						break;
					default:
						io.print(">");
						io.print("UNKNOWN COMMAND");
						unknownCommand();

					}

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

		private void listItems() throws VendingMachinePersistenceException {
			view.displayDisplayAllBanner();
			List<Item> itemList = service.getAllItems();
			view.displayItemList(itemList);
		}
		
		private void createItem() throws VendingMachinePersistenceException {
			view.displayCreateItemBanner();
			boolean hasErrors = false;
			do {
				Item currentItem = view.getNewItemInfo();
				try {
					service.createItem(currentItem);
					view.displayCreateSuccessBanner();
					hasErrors = false;
				} catch (VendingMachineDuplicateIdException | VendingMachineDataValidationException e) {
					hasErrors = true;
					view.displayErrorMessage(e.getMessage());
				}
			} while (hasErrors);
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
