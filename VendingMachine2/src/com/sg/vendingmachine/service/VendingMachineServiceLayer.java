package com.sg.vendingmachine.service;

import java.util.List;

import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;

public interface VendingMachineServiceLayer {

	void createItem(Item item) throws
	VendingMachineDuplicateIdException,
	VendingMachineDataValidationException,
	VendingMachinePersistenceException;
	
	List<Item> getAllItems() throws
	VendingMachinePersistenceException;
			
	Item getItem(String itemId) throws
	VendingMachinePersistenceException;
	
	Item removeItem(String itemId) throws
	VendingMachinePersistenceException;
}
}
