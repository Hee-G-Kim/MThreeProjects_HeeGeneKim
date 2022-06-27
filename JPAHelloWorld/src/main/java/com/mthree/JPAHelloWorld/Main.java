package com.mthree.JPAHelloWorld;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.mthree.utility.EntityManagerHelper;

public class Main {

	public static void main(String[] args) {
		EntityManager em= EntityManagerHelper.getEntityManager();
		Employee e = new Employee();
		e.setFname("Bikin");
		e.setLname("Ma");
		Address a= new Address("Sydney", 2000);
		e.setAddr(a);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit();
	}

}
