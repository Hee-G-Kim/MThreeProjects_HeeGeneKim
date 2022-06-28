package com.mthree.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PE")
public class PermanentEmployee extends Employee {

	private int bonus;

	public PermanentEmployee(String fname, int bonus) {
		super( id, fname);
		this.bonus = bonus;
	}

	
	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
