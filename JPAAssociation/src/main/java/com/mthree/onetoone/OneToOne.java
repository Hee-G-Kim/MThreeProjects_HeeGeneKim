package com.mthree.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import com.mthree.utility.EntityManagerHelper;

public class OneToOne {

	public static void main(String[] args) {
		EntityManager em= EntityManagerHelper.getEntityManager();
		Employee e = new Employee();
		e.setFname("sheng1");
		e.setLname("zhao1");
		Address a= new Address("Delhi", 5000);
		e.setAddr(a);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();

	}

}
