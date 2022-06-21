package com.mthree.service;

import java.util.List;

import com.mthree.Employee;

public interface IService {

         void saveEmployees(List<Employee> list);
         void modifyEmployees(List<Employee> list);

         public List<Employee> getAllEmployees(); //select * from employee
         public Employee getEmployeeById(int empid); // select * from employee where id =empid
         public String getEmployeeNameById(int empid); // select fname from employee where id= empid;
         int getEmployeeCount(); //select count(*) from employee
}