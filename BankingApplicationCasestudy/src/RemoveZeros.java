import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Scanner;

public class RemoveZeros {
         public static String removeLeadingZeroes(String str) {
                  String strPattern = "^0+(?!$)";
                  str = str.replaceAll(strPattern, "");
                  return str;
               }
         
         public static void main(String[] args) {
//                  // TODO Auto-generated method stub
//                  java.util.Date currentDate = new java.util.Date();    
//                  SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
//                  String dateOnly = dateFormat.format(currentDate);
//                  System.out.println(dateOnly);
                  Scanner sc = new Scanner(System.in);
                  System.out.println("Enter an integer: ");
                  String num = sc.next();
                  String result =removeLeadingZeroes(num);
                  System.out.println(result);
                 
         }

}
