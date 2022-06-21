package com.mthree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

         public static void main(String[] args) {
                  
                  //passing xml file into creator (interface)
                  //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
                  ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
                  //new Employee()? no Spring container is creating it
                  
                  Employee emp1 =context.getBean("e3", Employee.class);
                  System.out.println(emp1);

                  
                  //typecast to another reference variabe
                  ConfigurableApplicationContext cac=(ConfigurableApplicationContext)context;
                  cac.close();
                  /*
                  //pointing to same object
                  Employee emp2 =context.getBean("e2", Employee.class);
                  if(emp1 ==emp2) {
                           System.out.println("both pointing to same obj");
                  }else {
                           System.out.println("both pointing to different obj");
                  }*/

                  //setApplicationContext( applicationContext);
                  
         }
}
