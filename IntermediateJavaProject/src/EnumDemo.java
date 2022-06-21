

enum Gender{
         
         Male,Female;
   }
enum MathOperator {
         
         PLUS, MINUS, MULTIPLY, DIVIDE
         
 }
enum Days{
         Monday(0),Tuesday(1),Wednusday(2),Thursday(3),Friday(4),Saturday(5),Sunday(6);      
         int n;
         Days(int x)
         {
               n = x;
         }
         public int getValue()
         {
               return n;
         }
   }

//enum Calendar{
//         January=1,
//}


public class EnumDemo {
  //We use enums to define a set of predefined, related constants

         public static int Calculate(MathOperator operator, int num1, int num2) {
                  
                  switch (operator) {
                        case PLUS:
                           return num1+num2;
                       
                        case MINUS:
                                 return num1-num2;                      
                       
                        case MULTIPLY:
                                 return num1/num2;   
                               
                        case DIVIDE:
                                 return num1*num2;  
                                 //break;
                  default:
                           throw new UnsupportedOperationException();
                  }
                  
                  
         }
         
         
         public static void main(String[] args) {
                  System.out.println(Calculate(MathOperator.PLUS, 5,3));
                  System.out.println(Calculate(MathOperator.MINUS, 5,3));
                  System.out.println(Calculate(MathOperator.MULTIPLY, 5,3));
                  System.out.println(Calculate(MathOperator.DIVIDE, 5,3));
                  
                  Days aDay = Days.Monday; 
                  switch(aDay) {
                                          case Monday : System.out.println("ohh..its a Monday"); break;
                                          case Friday : System.out.println("its a Friday..weak End"); break;
                                          case Sunday : System.out.println("its a Saturday, holiday"); break;
                                          
                  }
                  switch(aDay.getValue()) {
                  
                              case 0 : System.out.println("its a Monday"); break;
                              case 5 : System.out.println("its a Friday"); break;
                              case 6 : System.out.println("its a Sundy"); break;

                  }
                  
         }
}
