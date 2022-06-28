package com.mthree.jointable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(indexes = "PE6")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
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
