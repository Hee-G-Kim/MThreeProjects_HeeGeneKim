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
	
	Employee e1 = new Employee("Taljeet","Singh");
	Employee e2 = new Employee("Bob","Builder");
	Employee e3 = new Employee("John","Ross");

	List<Employee> empList1  =new ArrayList<>();
	empList1.add(e1);
	empList1.add(e2);
	
	List<Employee> empList2 =new ArrayList<>();
	empList2.add(e1);
	empList2.add(e3);
	
	
	List<TechSkill> java =new ArrayList<>();
	List<TechSkill> python =new ArrayList<>();

	EntityTransaction tx = em.getTransaction();
	tx.begin();
//	em.persist(dept1);
//	em.persist(dept2);
	//em.persist(e1);
	tx.commit();

}
