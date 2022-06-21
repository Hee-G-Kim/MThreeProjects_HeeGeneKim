class Job1 implements Runnable//extends Thread
{
         
         public void method2() {
                  for(int j=1000; j<2000 ;j++) {
                           //System.out.println(name +"=" +j);
                           try {
                                    Thread.sleep(2000);;
                           } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                           }
                  }
         }
         
         @Override
         public void run() {
                  
                  //super.run();
                  method2();
         }
         
}

public class ForLoopDemo {
            public void method1() {
                     //method2();
                    String name =  Thread.currentThread().getName();
                     for(int i=0; i<1000 ;i++) {
                              System.out.println(name +"=" + i );
                     }
            }
            public void method2() {
                     String name =  Thread.currentThread().getName();
                     for(int j=1000; j<2000 ;j++) {
                              System.out.println("j=" + j);
                     }
            }
         public static void main(String[] args) {
                  ForLoopDemo demo = new ForLoopDemo();
                  //demo.method1();
                 // demo.method2();
                  
                  Job1 j1 = new Job1();
                  Thread t1 = new Thread(j1);
                  t1.start();//run will be called automatically
                  t1.setName("thread1");
                  t1.setName("thread1");
         }
}