class JointAccount{
         public int balance = 100;
         
         public void withdraw(int amount) {
                  balance = balance - amount; 
         }
}

class Job implements Runnable{

         private JointAccount account;
         
         public Job ( JointAccount account) {
                  this.account = account;
         }
         @Override
         public void run() {
                  makeWithDrawl(75);
                  if(account.balance<0) {
                           System.out.println("Big Problem!!");
                  }
         }
         //Synchronising the method lock the whole object(this)
         private   void makeWithDrawl(int amount) {
                  String name = Thread.currentThread().getName();
                 System.out.println(name + " has enterd inside make withdawl methd");
                 System.out.println(name + "is going to check the balance");
                 //IS it peice of code or the field
                 synchronized(account) {
                          
                          if(amount < account.balance) {
                                   System.out.println(name +"had checked the balance , and thre is sufficeint balace");
                                   System.out.println(name +"is going to actually withdraw");
                                   try {
                                            Thread.sleep(5000);
                                   } catch (InterruptedException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                   }
                                   account.withdraw(amount);
                                   System.out.println(name+ "has take the money money money!!");
                                   System.out.println(name+ "is exiting the makeWithDrawl method()");
                          }else {
                                   System.out.println("Not enough money");
                          }
                          
                 };//closing the synchronized block
         }
         
}
public class HusbandAndWife {

         public static void main(String[] args) {
                 
                  JointAccount account = new JointAccount();
                  Job job =new Job(account);
                  Thread t1 = new Thread(job);
                  t1.setName("Brad");
                  Thread t2 = new Thread(job);
                  t2.setName("Jennifer");
                
         }

}
