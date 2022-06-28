package com.mthree.jointable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(indexes = "PE6")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
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
