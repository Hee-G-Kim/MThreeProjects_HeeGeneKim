package com.sg.vendingmachine.service;

import java.util.ArrayList;
import java.util.List;

import com.sg.vendingmachine.dao.VendingMachineDao;
import com.sg.vendingmachine.dao.VendingMachinePersistenceException;
import com.sg.vendingmachine.dto.Item;

public class VendingMachineDaoStubImpl implements VendingMachineDao {

	public Item onlyItem;

	public VendingMachineDaoStubImpl() {
		onlyItem = new Item("0001");
		onlyItem.setName("Nuts");
		onlyItem.setPrice(5);
		onlyItem.setStockAmt(5);
	}

	public VendingMachineDaoStubImpl(Item testItem) {
		this.onlyItem = testItem;
	}

	@Override
	public Item addItem(String itemId, Item item) throws VendingMachinePersistenceException {
		if (itemId.equals(onlyItem.getItemId())) {
			return onlyItem;
		} else {
			return null;
		}
	}

	@Override
	public List<Item> getAllItems() throws VendingMachinePersistenceException {
		List<Item> itemList = new ArrayList<>();
		itemList.add(onlyItem);
		return itemList;
	}

	@Override
	public Item getItem(String itemId) throws VendingMachinePersistenceException {
		if (itemId.equals(onlyItem.getItemId())) {
			return onlyItem;
		} else {
			return null;
		}
	}

	@Override
	public Item removeItem(String itemId) throws VendingMachinePersistenceException {
		if (itemId.equals(onlyItem.getItemId())) {
			return onlyItem;
		} else {
			return null;
		}
	}
}
