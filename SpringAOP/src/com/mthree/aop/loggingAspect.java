package com.mthree.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class loggingAspect {
         
         @Pointcut(value = "execution (* *.save*(..))")
         public void savePointCut() {}
//         public void dummy() {
//                  
//         }
         
//         @Before(value = "savePointCut() ")
//         public void logBefore(JoinPoint jp) {
//                  System.out.println("inside method " + jp.getSignature().getName());
//         }

//         @AfterReturning(value = "savePointCut() ", returning ="r")
//         public void logAfter(JoinPoint jp, Object r) {
//                  System.out.println("inside method " + jp.getSignature().getName()  );
//         }
         
         @Around(value = "savePointCut() ")
         public Object logAround(ProceedingJoinPoint pj) throws Throwable {
                  Object returnvalue=null;
                  try {
                           //System.out.println("Like a before advise");
                           System.out.println("Inside method" + pj.getSignature().getName());
                           returnvalue =pj.proceed();//proceed will give call to business method
                           System.out.println("Exiting method" + pj.getSignature().getName());
                           
                           //System.out.println("after returning an advice");
                  } catch (Throwable e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                           throw e;
                  }
                  return returnvalue;
         }
}
