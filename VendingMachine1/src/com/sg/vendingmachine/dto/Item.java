package com.sg.vendingmachine.dto;

import java.util.Objects;

public class Item {

	
	private String name;
	private int cost;
	private int stockAmount;
	
	
	public Item() {
		super();
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getStockAmount() {
		return stockAmount;
	}
	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cost, name, stockAmount);
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
		return cost == other.cost && Objects.equals(name, other.name) && stockAmount == other.stockAmount;
	}
	@Override
	public String toString() {
		return "Item [name=" + name + ", cost=" + cost + ", stockAmount=" + stockAmount + "]";
	}
	
	
	

	
	
	
}
