package com.mthree;

import org.springframework.context.ApplicationListener;

public class TechDept implements ApplicationListener<EmployeeRecruitEvent> {

         @Override
         public void onApplicationEvent(EmployeeRecruitEvent event) {
                  System.out.println("Tech dept has started processign by assigning appropriate project to the new employee");
                  
         }

}
