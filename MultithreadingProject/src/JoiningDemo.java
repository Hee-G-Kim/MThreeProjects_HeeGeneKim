class Education implements Runnable{

         @Override
         public void run() {
                  System.out.println("Education is started");
                  System.out.println("Education is going on");
                  try {
                           Thread.sleep(4000);
                  } catch (InterruptedException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }
                  System.out.println("Education is completed");
         }
         
}
class Marriage implements Runnable{
         private Thread t;
         public Marriage(Thread t) {
                  this.t = t;
         }
         @Override
               public void run() {
                  try {
                           t.join();
                  } catch (InterruptedException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }
                        System.out.println("Wedding ceremony started");
                        System.out.println("Married");
                       
               }
                        
         }
         

public class JoiningDemo {

         public static void main(String[] args) {
                 
                  Education edu = new Education();
                  Thread t1 = new Thread(edu);
                  Marriage m = new Marriage(t1);
                  Thread t2 = new Thread(m);
                  t1.start();
                  t2.start();
                  
                  

         }

}
