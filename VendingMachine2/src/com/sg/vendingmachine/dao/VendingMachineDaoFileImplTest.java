package com.sg.vendingmachine.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sg.vendingmachine.dto.Item;

public class VendingMachineDaoFileImplTest {

	VendingMachineDao testDao;

	public VendingMachineDaoFileImplTest() {
	}

	@BeforeEach
	public void setUp() throws Exception {
		
		String testFile = "testroster.txt"; // Use the FileWriter to quickly blank the file

		new FileWriter(testFile);
		testDao = new VendingMachineDaoFileImpl(testFile);
	}

	

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}


	//=======================================
	
	
	@Test 
	public void testAddGetItem() throws Exception {// Create our method test inputs
		
		String itemId = "0001"; 
		Item item = new Item(itemId); 
		item.setFirstName("Ada"); 
		item.setLastName("Lovelace"); 
		item.setCohort("Java-May-1845"); 
		// Add the item to the DAO
		testDao.addItem(itemId, item); 
		// Get the item from the DAO 
		Item retrievedItem = testDao.getItem(itemId); 
		
		// Check the data is equal 
		assertEquals(item.getItemId(),retrievedItem.getItemId(), 
				"Checking item id."); 
		assertEquals(item.getFirstName(), retrievedItem.getFirstName(), 
				"Checking item first name."); 
		assertEquals(item.getLastName(), retrievedItem.getLastName(), 
				"Checking item last name."); 
		assertEquals(item.getCohort(), retrievedItem.getCohort(), 
				"Checking item cohort."); }
	


	
	
	
	
	@Test 
	public void testAddGetAllItems() throws Exception { 
		// Create our first item
		Item firstItem = new Item("0001"); 
		firstItem.setFirstName("Ada"); 
		firstItem.setLastName("Lovelace"); 
		firstItem.setCohort("Java-May-1845"); 
		// Create our second item 
		Item secondItem = new Item("0002"); 
		secondItem.setFirstName("Charles"); 
		secondItem.setLastName("Babbage"); 
		secondItem.setCohort(".NET-May-1845"); 
		// Add both our items to the DAO
		testDao.addItem(firstItem.getItemId(), firstItem); 
		testDao.addItem(secondItem.getItemId(), secondItem); 
		// Retrieve the list of all items within the DAO 
		List<Item> allItems = testDao.getAllItems(); 
		// First check the general contents of the list 
		assertNotNull(allItems, "The list of items must not null");
		assertEquals(2, allItems.size(),"List of items should have 2 items."); 
		// Then the specifics 
		assertTrue(testDao.getAllItems().contains(firstItem), 
				"The list of items should include Ada."); 
		assertTrue(testDao.getAllItems().contains(secondItem), 
				"The list of items should include Charles."); 
		
	}


	
	/** * Removes from the roster the item associated with the given id. 
	 * * Returns the item object that is being removed or null if 
	 * * there is no item associated with the given id * 
	 * * @param itemId id of item to be removed 
	 * * @return Item object that was removed or null if no item * was associated with the 		given item id */ 
	//Item removeItem(String itemId);
	/**
	 * Test method for
	 * {@link com.sg.vendingmachine.dao.VendingMachineDaoFileImpl#removeItem(java.lang.String)}.
	 */
	@Test public void testRemoveItem() throws Exception { 
		// Create two new items 
		Item firstItem = new Item("0001"); 
		firstItem.setFirstName("Ada"); 
		firstItem.setLastName("Lovelace"); 
		firstItem.setCohort("Java-May-1945"); 
		Item secondItem = new Item("0002"); 
		secondItem.setFirstName("Charles"); 
		secondItem.setLastName("Babbage"); 
		secondItem.setCohort(".NET-May-1945"); 
		
		// Add both to the DAO

		testDao.addItem(firstItem.getItemId(), firstItem); 
		testDao.addItem(secondItem.getItemId(), secondItem); 
		// remove the first item - Ada 
		Item removedItem = testDao.removeItem(firstItem.getItemId()); 
		// Check that the correct object was removed. 
		assertEquals(removedItem, firstItem, "The removed item should be Ada."); 
		// Get all the items 
		List<Item> allItems = testDao.getAllItems(); 
		// First check the general contents of the list 
		assertNotNull( allItems, "All items list should be not null."); 
		assertEquals( 1, allItems.size(), "All items should only have 1 item."); 
		// Then the specifics 
		assertFalse( allItems.contains(firstItem), 
				"All items should NOT include Ada.");
		assertTrue( allItems.contains(secondItem), 
				"All items should include Charles."); 
		// Remove the second item 
		removedItem = testDao.removeItem(secondItem.getItemId()); 
		// Check that the correct object was removed. 
		assertEquals( removedItem, secondItem, "The removed item should be Charles."); 
		// retrieve all of the items again, and check the list.
		allItems = testDao.getAllItems(); 
		// Check the contents of the list - it should be empty 
		assertTrue( allItems.isEmpty(), "The retrieved list of items should be empty."); 
		// Try to 'get' both items by their old id - they should be null! 
		Item retrievedItem = testDao.getItem(firstItem.getItemId());
		assertNull(retrievedItem, "Ada was removed, should be null."); 
		retrievedItem = testDao.getItem(secondItem.getItemId()); 
		assertNull(retrievedItem, "Charles was removed, should be null."); }
}
