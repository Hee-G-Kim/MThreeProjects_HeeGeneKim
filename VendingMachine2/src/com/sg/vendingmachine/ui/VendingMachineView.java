package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dto.Item;

public class VendingMachineView {

	// ???private UserIO io = new UserIOConsoleImpl();
	private UserIO io;

	// private UserIO io;
	public VendingMachineView(UserIO io) {
		this.io = io;
	}

	public Item getNewItemInfo() {

		/* Does not work here */
		// io = new UserIOConsoleImpl();

		String itemId = io.readString("Please enter Item ID");
		String firstName = io.readString("Please enter First Name");
		String lastName = io.readString("Please enter Last Name");
		String cohort = io.readString("Please enter Cohort");
		Item currentItem = new Item(itemId);
		currentItem.setFirstName(firstName);
		currentItem.setLastName(lastName);
		currentItem.setCohort(cohort);
		return currentItem;
	}

	public void displayCreateItemBanner() {
		io.print("=== Create Item ===");
	}

	public void displayCreateSuccessBanner() {
		io.readString("Item successfully created.  Please hit enter to continue");
	}

	public void displayItemList(List<Item> itemList) {
		for (Item currentItem : itemList) {
			String itemInfo = String.format("#%s : %s %s", currentItem.getItemId(),
					currentItem.getFirstName(), currentItem.getLastName());
			io.print(itemInfo);
		}
		io.readString("Please hit enter to continue.");
	}

	public void displayDisplayAllBanner() {
		io.print("=== Display All Items ===");
	}

	public void displayDisplayItemBanner() {
		io.print("=== Display Item ===");
	}

	public String getItemIdChoice() {
		return io.readString("Please enter the Item ID.");
	}

	public void displayItem(Item item) {
		if (item != null) {
			io.print(item.getItemId());
			io.print(item.getFirstName() + " " + item.getLastName());
			io.print(item.getCohort());
			io.print("");
		} else {
			io.print("No such item.");
		}
		io.readString("Please hit enter to continue.");
	}

	public void displayRemoveItemBanner() {
		io.print("=== Remove Item ===");
	}

	public void displayRemoveResult(Item itemRecord) {
		if (itemRecord != null) {
			io.print("Item successfully removed.");
		} else {
			io.print("No such item.");
		}
		io.readString("Please hit enter to continue.");
	}

	public void displayExitBanner() {
		io.print("Good Bye!!!");
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown Command!!!");
	}

	public int printMenuAndGetSelection() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Error
	//---------------
	
	public void displayErrorMessage(String errorMsg) {
		io.print("=== ERROR ===");
		io.print(errorMsg);
		}

	public void displayRemoveSuccessBanner() {
		System.out.println("Item successfully removed");
		
	}
	
	
	
}
