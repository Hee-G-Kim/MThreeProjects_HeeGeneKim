package exercisestatecapitals3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StateCapitalsApp {

         public static void main(String[] args) {
                        Map<String , StateCapitals3> capitals = new HashMap<>();
                        
                        Scanner sc;
                        try {
                                 sc = new Scanner(
                                                   (Readable) new BufferedReader(new FileReader
                                                                     ("MoreStateCapitals.txt")));
                                 // go through the file line by line
                                 while (sc.hasNextLine()) {
                                          String currentLine = sc.nextLine();
                                          String [] arrOfcurrentLine = currentLine.split("::",4);
                                        
                                          //[California,Sacramento,466488,97.2]
                                          //[Colorado,Denver,600158,153.4]
                                          
                                                   // make object from  String [] arrOfcurrentLine
                                                   StateCapitals3 stateCapital = new StateCapitals3(arrOfcurrentLine[1],
                                                                     Integer.parseInt(arrOfcurrentLine[2]) ,
                                                                     Double.parseDouble(arrOfcurrentLine[3]));
                                                   //put the object stateCapital in the map
                                                capitals.put(arrOfcurrentLine[0], stateCapital);
                                          }         
                        } catch (FileNotFoundException e) {
                                 e.printStackTrace();
                        }
                
         
                        System.out.println(capitals.size());
                        //Next, print out each state and its capital's name, population, and square mileage to the 
                        //screen. 
                        for (String i: capitals.keySet()) {
                                 System.out.println(i);
                        }
                        
                        //Then, prompt the user for a population limit, 
                        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                        System.out.println("Enter population limit: ");

                        int popLimit = myObj.nextInt();  // Read user input
                        //System.out.println("these are the list of citoes with this population limit: ");
                        for (StateCapitals3 i: capitals.values()) {
                                 int storedPopLimit =i.getPopulation();
                                 if(storedPopLimit <= popLimit)
                                 System.out.println(i);
                        }
                    
         }

         
         
         
         
         
         
         
         
         
         
         
}
