package com.mthree.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mthree.Employee;

//@Component(value = "dao") -simplest way to spring not ot recognise Eployeedao
@Component(value = "dao")
public class EmployeeDao implements IDAO {
         
         @Autowired
         private PlatformTransactionManager transactionManager;
         
         @Autowired
         private JdbcTemplate template;
         
         
         @Transactional(propagation = Propagation.REQUIRES_NEW)
         //@Transactional(propagation = Propagation.SUPPORTS)
         // as there is an existing traction that statred at service layer this method 
         //will simply support the same
         @Override
         public void saveEmployee(Employee emp) {
                  
                  //System.out.println("Inside Dao layer");
                  System.out.println("Employee wiil be persisted" + emp);
                  String insert = " insert into employee(id ,fname,lname) values (?,?,?)";
                  template.update(insert, emp.getEid(), emp.getFname(), emp.getLname());
         }

         @Override
         public void modifyEmployee(Employee emp) {
                  
                  //System.out.println("Inside Dao layer");

         }

         @Override
         public List<Employee> getAllEmployees() {
                  String select = "select * from employee";
//              List<Employee> employees = template.query(select , new   BeanPropertyRowMapper<Employee>(Employee.class));;
                  List<Employee> employees = template.query(select , new EmployeeRowMapper());

                  return employees;
         }

         @Override
         public Employee getEmployeeById(int empid) {
                  //String select = "select * from employee where id =empid";
                  String select = "select * from employee where id =?";
                 return template.queryForObject(select,new Object[]{empid},new EmployeeRowMapper());
         }

         @Override
         public String getEmployeeNameById(int empid) {
                  String select = "select fname from employee where id=?";
                  return template.queryForObject(select, String.class ,empid);
         }

         @Override
         public int getEmployeeCount() {
                  String select = "select count(*) from employee";
                  return template.queryForObject(select, Integer.class);
         }

}
