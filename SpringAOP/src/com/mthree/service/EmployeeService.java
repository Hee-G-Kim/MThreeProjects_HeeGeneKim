package com.mthree.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mthree.Employee;
import com.mthree.dao.EmployeeDao;
import com.mthree.dao.IDAO;

@Component(value = "service")
public class EmployeeService implements IService{
         
         //org.springframework.jdbc.datasource.DataSourceTransactionManager
         @Autowired
         private PlatformTransactionManager transactionManager;
         
         
         @Autowired
         private IDAO dao;
         //private EmployeeDao empdao;
         
         @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class) //As existing transcation is 
         //not present in main method it will start a 
         //new traction at service layer-this mehod
         public void saveEmployees(List<Employee> emps) {
                 // System.out.println("Inside service layer");   
                  for(Employee e : emps) {
                           dao.saveEmployee(e);
                  }
         }

         @Override
         public void modifyEmployees(List<Employee> list) {
                  //System.out.println("Inside service layer modify");
         }

         @Override
         public List<Employee> getAllEmployees() {
                  
                  return dao.getAllEmployees();
         }

         @Override
         public Employee getEmployeeById(int empid) {
                  // TODO Auto-generated method stub
                  return null;
         }

         @Override
         public String getEmployeeNameById(int empid) {   
                  return dao.getEmployeeNameById(empid);
         }

         @Override
         public int getEmployeeCount() {
                  // TODO Auto-generated method stub
                  return 0;
         }

}
