
public class ClassForNameDemo {

         public static void main(String[] args) {
                  System.out.println("Inside main of ClassForNameDemo");
                  try {
                           Class.forName("com.mthree.StaticDemo");
                  } catch (ClassNotFoundException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }
         }

}
