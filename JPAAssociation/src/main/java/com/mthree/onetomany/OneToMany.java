package com.mthree.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.mthree.onetomany.Department;
import com.mthree.onetomany.Employee;
import com.mthree.utility.EntityManagerHelper;

public class OneToMany {
	public static void main(String[] args) {
		
		EntityManager em= EntityManagerHelper.getEntityManager();
		
		Employee e1 = new Employee("Tal","Singh");
		Employee e2 = new Employee("Bob","Builder");
		Employee e3 = new Employee("John","Ross");
		Department dept1 = new Department("Tech");
		Department dept2 = new Department("HR");
		List<Employee> empList  =new ArrayList<>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		//dept1.setEmployees(empList);
		//e1.setDept(dept1);
		
		dept2.setEmployees(empList);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(dept1);
		em.persist(dept2);
		//em.persist(e1);
		tx.commit();

	}

}
