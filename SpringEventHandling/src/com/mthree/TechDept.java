package com.mthree;

import org.springframework.context.ApplicationListener;

public class TechDept implements ApplicationListener<employeeRecruitEvent> {

         @Override
         public void onApplicationEvent(employeeRecruitEvent event) {
                  System.out.println("Tech dept has started processign by assigning appropriate project to the new employee");
                  
         }

}
