package com.mthree;

import org.springframework.context.ApplicationListener;

public class FinanceDept implements ApplicationListener<employeeRecruitEvent> {
         @Override
         public void onApplicationEvent(employeeRecruitEvent event) {
                  System.out.println("finance dept has started open salary account");
                  
         }
}
