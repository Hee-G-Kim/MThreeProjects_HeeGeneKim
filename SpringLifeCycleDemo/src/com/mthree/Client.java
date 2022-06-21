package com.mthree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

         public static void main(String[] args) {
                  
                  ApplicationContext context = new ClassPathXmlApplicationContext("service.xml");
                  ReportService rs= context.getBean("rs1", ReportService.class);
                  rs.generateReport();
                  ConfigurableApplicationContext c= (ConfigurableApplicationContext) context;
                  c.close();
         }

}
