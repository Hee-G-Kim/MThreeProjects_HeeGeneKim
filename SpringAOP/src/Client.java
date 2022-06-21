import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mthree.Employee;
import com.mthree.service.EmployeeService;
import com.mthree.service.IService;

public class Client {

         public static void main(String[] args) {
                  ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
                  IService empService = context.getBean("service", IService.class);
                  
                  List<Employee> employees = new ArrayList<>();
                  employees.add(new Employee(801, "Pip", "mu"));
                  employees.add(new Employee(802, "Mosss", "Doe"));
                  //mployees.add(new Employee(332, "Jane", "Doe"));
                  
                  empService.saveEmployees(employees);
                  
 /*
              * List<Employee> emps = empService.getAllEmployees();
              * 
              * for(Employee employee : emps) { System.out.println(employee); } // Employee e
              * = empService.getEmployeeById(1); // System.out.println(e);
              * System.out.println(empService.getEmployeeNameById(1));
              * System.out.println(" count of rows : " + empService.getEmployeeCount());
  */
         }

}
