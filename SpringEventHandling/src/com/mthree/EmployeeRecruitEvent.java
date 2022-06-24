package com.mthree;

import org.springframework.context.ApplicationEvent;

public class EmployeeRecruitEvent extends ApplicationEvent {

         public EmployeeRecruitEvent(Object source) {
                  //calling parent constructor
                  super(source);
                  System.out.println("");
         }

}
