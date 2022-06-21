package exerciseStateCapitals2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCapitals2 {

         public static void main(String[] args) throws FileNotFoundException {
                  
                  Map<String, String> capitals= new HashMap<>();

                  //StateCapitals.txt should be in project file: JavaClassesandObjectsEngage
                  Scanner sc = new Scanner(
                                    (Readable) new BufferedReader(new FileReader("StateCapitals.txt")));
                                // go through the file line by line
                  while (sc.hasNextLine()) {
                                    String currentLine = sc.nextLine();
                                    String [] arrOfcurrentLine = currentLine.split("::",2);
                                    for (String a : arrOfcurrentLine) {
                                             capitals.put(arrOfcurrentLine[0],arrOfcurrentLine[1] );
                                    }         
                  }
                  System.out.println(capitals.size());
                  for (String i : capitals.keySet()) {
                           System.out.println(i);
                         }
                  
         }

}
