package com.sg.vendingmachine.dao;

import java.util.List;

import com.sg.vendingmachine.dto.Item;

public interface VendingMachineDao {
	/**
	 * Adds the given Item to the roster and associates it with the giv en
	 * item id. If there is already a item associated with the given item
	 * id it will return that item object, otherwise it will return null.
	 *
	 * @param itemId id with which item is to be associated
	 * @param item   item to be added to the roster
	 * @return the Item object previously associated with the given item id if
	 *         it exists, null otherwise
	 */
	Item addItem(String itemId, Item item) throws VendingMachinePersistenceException;

	/**
	 * Returns a List of all items in the roster.
	 *
	 * @return List containing all items in the roster.
	 */
	List<Item> getAllItems()throws VendingMachinePersistenceException;

	/**
	 * Returns the item object associated with the given item id. Returns null
	 * if no such item exists
	 *
	 * @param itemId ID of the item to retrieve
	 * @return the Item object associated with the given item id, null if no
	 *         such item exists
	 */
	Item getItem(String itemId)throws VendingMachinePersistenceException;

	/**
	 * Removes from the roster the item associated with the given id. Returns the
	 * item object that is being removed or null if there is no item
	 * associated with the given id
	 *
	 * @param itemId id of item to be removed
	 * @return Item object that was removed or null if no item was associated
	 *         with the given item id
	 */
	Item removeItem(String itemId)throws VendingMachinePersistenceException;

	
}
