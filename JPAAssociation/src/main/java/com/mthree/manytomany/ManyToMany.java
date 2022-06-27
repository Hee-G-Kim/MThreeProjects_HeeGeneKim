package com.mthree.manytomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.mthree.manytomany.TechSkill;
import com.mthree.manytomany.Employee;
import com.mthree.utility.EntityManagerHelper;

public class ManyToMany {
	
	EntityManager em= EntityManagerHelper.getEntityManager();
	
	Employee e1 = new Employee("Tal","Singh");
	Employee e2 = new Employee("Bob","Builder");
	Employee e3 = new Employee("John","Ross");
	//Create 2 LISTS
	List<Employee> javaExperts = new ArrayList<>();
	javaExperts.add(e1);
	
	List<Employee> pythonExperts = new ArrayList<>();
	pythonExperts.add(e1);
	pythonExperts.add(e3);
	
	
	TechSkill t1 = new TechSkill();
	t1.
	//Peristemce
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(e1);
	em.persist(e2);
	em.persist(e3);
	tx.commit();

}
