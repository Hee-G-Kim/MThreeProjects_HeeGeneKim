import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataTimeDemo {

               public static void main(String[] args) {
                        
                        LocalDate today = LocalDate.now();
                        System.out.println(today);

                        LocalTime time = LocalTime.now();
                        System.out.println(time);
                        
                        LocalDateTime dateTime = LocalDateTime.now();
                        System.out.println(dateTime);
                        
                        LocalDate birthday = LocalDate.of(1976, Month.SEPTEMBER, 18);
                        System.out.println("Specific Date="+birthday);

      
                        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
                        System.out.println("Current Date in IST="+todayKolkata);
                        
                        System.out.println("10 days after today will be "+today.plusDays(10));
                        System.out.println("10 weeks BEFORE today will be "+today.minusWeeks(10));
                        
                        Period p = Period.between(birthday, today);
                        System.out.println(p);
                        
                        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() + 
                                          " months, and " + p.getDays() + " days old.");
                        
                        //LocalDate date;
                        System.out.println(today.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
                        System.out.println(today.format(DateTimeFormatter.ofPattern("d:MMM:uuuu")));
                        System.out.println(today.format(DateTimeFormatter.ofPattern("d/MM/uuuu")));
                        System.out.println(today.format(DateTimeFormatter.ofPattern("d/M/uuuu")));
                        
               }

}
