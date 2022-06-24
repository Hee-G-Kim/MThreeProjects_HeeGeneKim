package com.mthree;

import org.springframework.context.ApplicationListener;

public class FinanceDept implements ApplicationListener<EmployeeRecruitEvent> {
         @Override
         public void onApplicationEvent(EmployeeRecruitEvent event) {
                  System.out.println("finance dept has started open salary account");
                  
         }
}
