package com.mthree.utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

	private static EntityManagerFactory factory = null;
	//private EntityManager em = null;
	
	static {
		factory = Persistence.createEntityManagerFactory("jpabasics");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
//		em=factory.createEntityManager();
//		return em;
	}
	
}
