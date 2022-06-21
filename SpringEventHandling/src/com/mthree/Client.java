package com.mthree;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

         public static void main(String[] args) {
                  
                  ApplicationContext context = new ClassPathXmlApplicationContext("event.xml");
                  HRDept  hdept = context.getBean("hr", HRDept.class);
                                    hdept.recruitEmployee();

         }

}
