package exercisestatecapitals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class testCapitals {

         public static void main(String[] args) {
                  
//                  Alabama
//                  Alaska
//                  Arizona
//                  Arkansas
//               
//                  Montgomery
//                  Juneau
//                  Phoenix
//                  Little Rock
                  Map<String, String> capitals= new HashMap<>();
                  capitals.put("Alabama", "Montgomery");
                  capitals.put("Alaska", "Juneau");
                  capitals.put("Arizona", "Phoenix");
                  capitals.put("Arkansas", "Little Rock");
                  
                  Set<String> keys = capitals.keySet();                                                         
                  for(String key: keys) {
                           System.out.println(key + ":" + capitals.get(key));
                  }
                  
                  
 

         }

}
