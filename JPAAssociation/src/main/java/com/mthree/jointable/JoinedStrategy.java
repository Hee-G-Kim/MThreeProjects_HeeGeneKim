package com.mthree.jointable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.mthree.jointable.ContractEmployee;
import com.mthree.jointable.PermanentEmployee;
import com.mthree.utility.EntityManagerHelper;

public class JoinedStrategy {

	public static void main(String[] args) {
		Employee p1 = new PermanentEmployee( "Ben", 1000);
		Employee p2 = new PermanentEmployee( "Bob", 1000);
		
		Employee c1 = new ContractEmployee("John", "Mthree");
		Employee c2 = new ContractEmployee("Jane", "Wiley");
		
		EntityManager em = EntityManagerHelper.getEntityManager();
				
		EntityTransaction tx = em.getTransaction();
		
	
		tx.begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(c1);
		em.persist(c2);
		tx.commit();
		

	}

}
