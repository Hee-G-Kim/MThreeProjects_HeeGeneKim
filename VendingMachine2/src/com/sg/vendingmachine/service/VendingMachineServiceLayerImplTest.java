package com.sg.vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;

public class VendingMachineServiceLayerImplTest {

	private VendingMachineServiceLayer service;

	public VendingMachineServiceLayerImplTest() {
		VendingMachineDao dao = new VendingMachineDaoStubImpl();
		VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
		service = new VendingMachineServiceLayerImpl(dao, auditDao);
	}

	@Test
	public void testCreateValidItem() {
		// ARRANGE
		Item item = new Item("0002");
		item.setFirstName("Charles");
		item.setLastName("Babbage");
		item.setCohort(".NET-May-1845");
		// ACT
		try {
			service.createItem(item);
		} catch (VendingMachineDuplicateIdException | VendingMachineDataValidationException
				| VendingMachinePersistenceException e) {
			// ASSERT
			fail("Item was valid. No exception should have been thrown.");
		}
	}

	@Test
	public void testCreateDuplicateIdItem() {
		// ARRANGE
		Item item = new Item("0001");
		item.setFirstName("Charles");
		item.setLastName("Babbage");
		item.setCohort(".NET-May-1845");
		// ACT
		try {
			service.createItem(item);
			fail("Expected DupeId Exception was not thrown.");
		} catch (VendingMachineDataValidationException | VendingMachinePersistenceException e) {
			// ASSERT
			fail("Incorrect exception was thrown.");
		} catch (VendingMachineDuplicateIdException e) {
			return;
		}
	}

	@Test
	public void testCreateItemInvalidData() throws Exception {
		// ARRANGE
		Item item = new Item("0002");
		item.setFirstName("");
		item.setLastName("Babbage");
		item.setCohort(".NET-May-1845");
		// ACT
		try {
			service.createItem(item);
			fail("Expected ValidationException was not thrown.");
		} catch (VendingMachineDuplicateIdException | VendingMachinePersistenceException e) {
			// ASSERT
			fail("Incorrect exception was thrown.");
		} catch (VendingMachineDataValidationException e) {
			return;
		}
	}

	@Test
	public void testGetAllItems() throws Exception {
		// ARRANGE
		Item testClone = new Item("0001");
		testClone.setFirstName("Ada");
		testClone.setLastName("Lovelace");
		testClone.setCohort("Java-May-1845");
		// ACT & ASSERT
		assertEquals(1, service.getAllItems().size(), "Should only have one item.");
		assertTrue(service.getAllItems().contains(testClone), "The one item should be Ada.");
	}

	@Test
	public void testGetItem() throws Exception {
		// ARRANGE
		Item testClone = new Item("0001");
		testClone.setFirstName("Ada");
		testClone.setLastName("Lovelace");
		testClone.setCohort("Java-May-1845");
		// ACT & ASSERT
		Item shouldBeAda = service.getItem("0001");
		assertNotNull(shouldBeAda, "Getting 0001 should be not null.");
		assertEquals(testClone, shouldBeAda, "Item stored under 0001 should be Ada.");
		Item shouldBeNull = service.getItem("0042");
		assertNull(shouldBeNull, "Getting 0042 should be null.");
	}

	@Test
	public void testRemoveItem() throws Exception {
		// ARRANGE
		Item testClone = new Item("0001");
		testClone.setFirstName("Ada");
		testClone.setLastName("Lovelace");
		testClone.setCohort("Java-May-1845");
		// ACT & ASSERT
		Item shouldBeAda = service.removeItem("0001");
		assertNotNull(shouldBeAda, "Removing 0001 should be not null.");
		assertEquals(testClone, shouldBeAda, "Item removed from 0001 should be Ada.");
		Item shouldBeNull = service.removeItem("0042");
		assertNull(shouldBeNull, "Removing 0042 should be null.");
	}

	
	
	
	/*
	 * @BeforeEach void setUp() throws Exception { }
	 * 
	 * @AfterEach void tearDown() throws Exception { }
	 */
}
