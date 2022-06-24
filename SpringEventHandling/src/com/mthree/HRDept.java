package com.mthree;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HRDept implements ApplicationContextAware {
 private ApplicationContext context;
 
         public  void recruitEmployee() {
                  System.out.println("Inside RecruitEmployee");
                  context.publishEvent(new EmployeeRecruitEvent(this));
         }

         @Override
         public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
                  System.out.println("Inside setApplicationContext");
                  this.context = applicationContext;
         }

}
