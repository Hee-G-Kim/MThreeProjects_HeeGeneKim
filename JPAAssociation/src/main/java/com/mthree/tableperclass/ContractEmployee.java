package com.mthree.tableperclass;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CE")
public class ContractEmployee extends Employee {
	private String contractorName;

	
	public ContractEmployee(String fname, String contractorName) {
		super(id, fname);
		this.contractorName = contractorName;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}
	
}
