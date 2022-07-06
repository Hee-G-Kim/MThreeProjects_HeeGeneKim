package com.sg.vendingmachine.dto;

import java.util.Objects;

import com.sg.vendingmachine.dto.Item;

public class Item {

	
	
	// int cost;
	//private int stockAmount;
	
	private String firstName;
	private String lastName;
	private String itemId;
	// Programming Language + cohort month/year
	private String cohort;

	public Item() {
		
	}
	
	public Item(String itemId) {
		this.itemId = itemId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getItemId() {
		return itemId;
	}

	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cohort, firstName, lastName, itemId);
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
		return Objects.equals(cohort, other.cohort) 
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) 
				&& Objects.equals(itemId, other.itemId);
	}

	@Override
	public String toString() {
		return "Item [firstName=" + firstName + ", lastName=" + lastName 
				+ ", itemId=" + itemId + ", cohort=" + cohort + "]";
	}

	
	
	

	
	
	
}
