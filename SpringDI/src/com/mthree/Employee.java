package com.mthree;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component(value = "e3")
public class Employee implements BeanNameAware, ApplicationContextAware //InitializingBean
{
         
         @Value(value = "99")
         private int id;
         @Value(value = "Randy")
         private String fname;
         @Value(value = "Park")
         private String lname;
         @Autowired
         @Qualifier(value = "a5")
         private Address addr; /*has a relationship-Employee is dependant on address 
         thus address is its dependancy*/
         private ApplicationContext ctx;
         
         public Employee() {
                  System.out.println("Inside Default constructor of Employee");
         }
         public Employee(int id, String fname, String lname, Address addr) {
                  System.out.println("Inside parametrised constructor of Employee");
                 
                  this.id = id;
                  this.fname = fname;
                  this.lname = lname;
                  this.addr= addr;
         }

         public int getId() {
                  return id;
         }

         public void setId(int id) {
                  System.out.println("Inside setId of Employee");
                  this.id = id;
         }

         public String getFname() {
                  return fname;
         }

         public void setFname(String fname) {
                  System.out.println("Inside setFname  of Employee");
                  this.fname = fname;
         }

         public String getLname() {
                  return lname;
         }

         public void setLname(String lname) {
                  System.out.println("Inside setLname  of Employee");
                  this.lname = lname;
         }

         public Address getAddr() {
                  return addr;
         }
         //@Autowired
         public void setAddr(Address addr) {
                  System.out.println("Inside set address(Address addr)  of Employee");
                  this.addr = addr;
         }
         @Override
         public String toString() {
                  return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", addr=" + addr.toString() + "]";
         }
         
         //BeanNameAware, 
         @Override
         public void setBeanName(String arg0) {   
                  System.out.println("Inside setBeanName of Employee: "+arg0);
         }
         //ApplicationContextAware 
         @Override
         public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                  System.out.println("Inside  of setApplicationContext of Employee" + applicationContext);
                  this.ctx = applicationContext;
         }
/*     @Override
         public void afterPropertiesSet() throws Exception {
                 
                  System.out.println("Inside  of afterPropertiesSet of Employee" );
                  this.fname= "leo";
                  this.lname="lee";
                  this.addr = ctx.getBean("a2",Address.class);

         }*/

         public void doInit() {
                  System.out.println("Inside  of doInit of Employee" );
                  this.fname= "leo";
                
                  this.lname="lee";
                  //this.addr = ctx.getBean("a2", Address.class);

         }
         public void doDestroy() {
                  System.out.println("Inside  of doDestroy of Employee" );

         }
        
}
