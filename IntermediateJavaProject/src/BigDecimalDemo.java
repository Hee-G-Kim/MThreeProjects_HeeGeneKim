import java.math.BigDecimal;
import java.math.RoundingMode;

/*Used for :This class is used to represent arbitrary PRECISION DECIMAL numbers:
 * Precision
 * 
 Each of the numbers below has a precision of 5:
 2.5973
 87.654
 2345.3

Scale
 The scale value is the number of digits to the right of the decimal point
 1.9974: scale = 4
 56.754: scale = 3
 1234.3: scale = 1

 * BigDecimal is an immutable type (just like String). 
That means that a BigDecimal object's value can't be changed once it is set*/
//



public class BigDecimalDemo {

               public static void main(String[] args) {
                        
                        BigDecimal a = new BigDecimal("42.356");
                        System.out.println(a);
                        
                        BigDecimal b = a.setScale(1, RoundingMode.UP); 
                        System.out.println(b.toString());
                        
                        b = a.setScale(1, RoundingMode.DOWN); 
                        System.out.println(b.toString());

                        b = a.setScale(2, RoundingMode.UP); 
                        System.out.println(b.toString());
                        
                        b = a.setScale(2, RoundingMode.DOWN); 
                        System.out.println(b.toString());

               }

}
