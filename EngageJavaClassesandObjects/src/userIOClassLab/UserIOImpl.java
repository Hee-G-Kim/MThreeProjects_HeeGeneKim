package userIOClassLab;

import java.util.Scanner;

public class UserIOImpl implements UserIO{
         Scanner scanner  =new Scanner(System.in);
         
         @Override
         public void print(String message) {
                  
                  System.out.println("Printing Message: " +message);
         }
         
        
         
         @Override
         public String readString(String prompt) {
                  // TODO Auto-generated method stub
                  return null;
         }

         
         @Override
         public int readInt(String prompt) {
                 
                  print(prompt);
                  int input = scanner.nextInt();
                  
                  return input;
         }

         @Override
         public int readInt(String prompt, int min, int max) {
                  String fullPrompt = prompt +  "("+min + " and " + max +")";
                  
                  //prompt example"enter 2 numbers between 1 and 10"
                  
                  int inputInt = scanner.nextInt();
////                  if (inputInt <max &&  inputInt >min ) {
////                           return inputInt;}
////                           else {
////                                    readInt("Try again -Enter a number between: " +min +" "+ max);
////                           }
//                  while(inputInt > max ||  inputInt < min ) {
//                          readInt("Try again -Enter a number between: " +min +" "+ max);
//                          inputInt = scanner.nextInt();
//                  }
                  do {
                           print(fullPrompt);
                           inputInt = scanner.nextInt();}
                  while(inputInt > max ||  inputInt < min);
                  
                  
                  return inputInt;
                  
                  /*Display a prompt to the user to enter an integer between a specified min and max range, 
                  and read in an integer. If the user's number does not fall within the range, keep prompting
                  the user for new input until it does. The prompt message and the min and max values 
                  should be passed in as parameters. The value read in from the console should be the return of the method.*/
                  
         }

         @Override
         public double readDouble(String prompt) {
                  // TODO Auto-generated method stub
                  return 0;
         }

         @Override
         public double readDouble(String prompt, double min, double max) {
                  // TODO Auto-generated method stub
                  return 0;
         }

         @Override
         public float readFloat(String prompt) {
                  // TODO Auto-generated method stub
                  return 0;
         }

         @Override
         public float readFloat(String prompt, float min, float max) {
                  // TODO Auto-generated method stub
                  return 0;
         }

         @Override
         public long readLong(String prompt) {
                  // TODO Auto-generated method stub
                  return 0;
         }

         @Override
         public long readLong(String prompt, long min, long max) {
                  // TODO Auto-generated method stub
                  return 0;
         }

}
