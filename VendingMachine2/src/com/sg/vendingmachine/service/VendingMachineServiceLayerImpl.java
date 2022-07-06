package com.sg.vendingmachine.service;

import java.util.List;

import com.sg.vendingmachine.dao.VendingMachineAuditDao;
import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;

public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

private VendingMachineAuditDao auditDao;
	
	VendingMachineDao dao;
	public VendingMachineServiceLayerImpl(VendingMachineDao dao,VendingMachineAuditDao auditDao) {
		this.dao = dao;
		this.auditDao = auditDao;
	}

	@Override
	public void createItem(Item item) throws VendingMachineDuplicateIdException,
			VendingMachineDataValidationException, VendingMachinePersistenceException {
		// First check to see if there is alreay a item
		// associated with the given item's id
		// If so, we're all done here -
		// throw a VendingMachineDuplicateIdException
		if (dao.getItem(item.getItemId()) != null) {
			throw new VendingMachineDuplicateIdException(
				"ERROR: Could not create item. Item Id "
			+ item.getItemId()
			+ " already exists");
		}

		// Now validate all the fields on the given Item object.
		// This method will throw an
		// exception if any of the validation rules are violated.
		validateItemData(item);

		// We passed all our business rules checks so go ahead
		// and persist the Item object
		dao.addItem(item.getItemId(), item);
		// The item was successfully created, now write to the audit log
		auditDao.writeAuditEntry("Item " + item.getItemId() + " CREATED.");
	}

	@Override
	public List<Item> getAllItems() throws VendingMachinePersistenceException {

		return dao.getAllItems();
	}

	@Override
	public Item getItem(String itemId) throws VendingMachinePersistenceException {

		return dao.getItem(itemId);
	}

	@Override
	public Item removeItem(String itemId) throws VendingMachinePersistenceException {

		Item removedItem = dao.removeItem(itemId);
		// Write to audit log
		auditDao.writeAuditEntry("Item " + itemId + " REMOVED.");
		return removedItem;
	}

	private void validateItemData(Item item) throws
		VendingMachineDataValidationException {
		
		              /**?get from where?*/
			if (item.getFirstName() == null
			|| item.getFirstName().trim().length() == 0 //empty/whitespace only,
			|| item.getLastName() == null
			|| item.getLastName().trim().length()== 0
			|| item.getCohort() == null
			|| item.getCohort().trim().length() == 0) {
				throw new VendingMachineDataValidationException
			(
				"ERROR: All fields [First Name, LastName, Cohort] are required.");
			}
	
	}
}
