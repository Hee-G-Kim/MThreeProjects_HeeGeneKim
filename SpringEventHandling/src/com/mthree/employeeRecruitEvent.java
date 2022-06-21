package com.mthree;

import org.springframework.context.ApplicationEvent;

public class employeeRecruitEvent extends ApplicationEvent {

         public employeeRecruitEvent(Object source) {
                  //calling parent constructor
                  super(source);
                  System.out.println("");
         }

}
