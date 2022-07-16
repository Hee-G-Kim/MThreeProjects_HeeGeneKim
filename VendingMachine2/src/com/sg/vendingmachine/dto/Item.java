package com.sg.vendingmachine.dto;

import java.util.Objects;

import com.sg.vendingmachine.dto.Item;

public class Item {

	
	
	private String itemId;
	private String Name;
	private double price;
	private int stockAmount;
	

	public Item() {
		
	}
	
	public Item(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	
	public String getItemId() {
		return itemId;
	}

	public int getStockAmt() {
		return stockAmount;
	}

	public void setStockAmt(int amount) {
		this.stockAmount = amount;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double amount) {
		this.price = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, Name, price, stockAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(stockAmount, other.stockAmount) 
				&& Objects.equals(Name, other.Name)
				&& Objects.equals(price, other.price) 
				&& Objects.equals(itemId, other.itemId);
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", Name=" + Name + ", price=" + price + ", stockAmount=" + stockAmount + "]";
	}


	
	
	
}
