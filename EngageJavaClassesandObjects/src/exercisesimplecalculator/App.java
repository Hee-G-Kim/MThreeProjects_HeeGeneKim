package exercisesimplecalculator;

import java.util.Scanner;

public class App {

         public static void main(String[] args) {
                  // TODO Auto-generated method stub
                  Scanner scanner = new Scanner(System.in);
                  boolean stillPlaying= true;
                  while(stillPlaying) {
                           System.out.println("Type an operation + ,- ,* or / or type esc to exit");
                           String operand =scanner.next();
                           int num1;
                           int num2;
                           System.out.println("Type first operand");
                           num1 = scanner.nextInt();
                           System.out.println("Type second operand");
                           num2 = scanner.nextInt();
                           SimpleCalculator calc = new SimpleCalculator();
                           if(operand == "esc") {
                                     stillPlaying=false;
                                    System.out.println("Thank you");
                           }else {
                                    calc.CalculateString ( operand, num1, num2);}
                           }
                            
                
                   
                   
                   
         }

}
