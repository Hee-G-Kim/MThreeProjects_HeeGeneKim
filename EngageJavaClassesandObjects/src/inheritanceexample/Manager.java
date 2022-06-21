package inheritanceexample;

public class Manager extends Employee {

                     public Manager() {
            
                     }
            
                     public void hire() {
                              // code to hire someone...
                     }
            
                     public void fire() {
                              // code to fire someone...
                     }
            
                     public void givePerformanceReview() {
                              // code to give performance review
                     }
                     
                     //complete Ovrride
                     /*@Override
                     public void createYearlyObjectives() {
                         // we're overriding the version of this method in Employee
                         // put new code here...
                     }*/
                     
                     //Override + parent code
                     @Override
                     public void createYearlyObjectives() {
                     // we're overriding the version of this method in Employee
                     // put new code here...
                     super.createYearlyObjectives();
                     // put more new code here...
                     }

}
