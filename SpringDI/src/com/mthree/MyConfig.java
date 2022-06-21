package com.mthree;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration //Replacement of Entire XML
@ComponentScan(basePackages= "com.mthree")
public class MyConfig {

         @Bean(name = "a4")
         @Primary //will be given priority
         public Address getAddress1() {
                  Address a = new Address("England", "London", "Something rd", "2012");
                  return a;
         }
         @Bean(name = "a5")
         public Address getAddress2() {
                  Address a = new Address("Germany", "Berlin", "Something rd", "2222");
                  return a;
         }
}
