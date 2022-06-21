import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

enum Status{
         OPEN,CLOSED;
}
class Task{
         private Status status;
         private int points;
         
         public Task(int points, Status status) {
                  this.status = status;
                  this.points  = points;
         }

         public Status getStatus() {
                  return status;
         }

         public void setStatus(Status status) {
                  this.status = status;
         }

         public int getPoints() {
                  return points;
         }

         public void setPoints(int points) {
                  this.points = points;
         }

         @Override
         public String toString() {
                  return "Task status=" + status + ", points=" + points;
         }
         
         
         
}

public class StreamAPIDemo {

         public static void main(String[] args) {
                  
                  List<Integer> list2 = Arrays.asList(4,5,6);
                  list2.stream().forEach(new Consumer<Integer>() {
                           @Override
                           public void accept(Integer t) {
                                    System.out.println(t);                              
                           } 
                  });
                  list2.stream().forEach((str)-> System.out.println(str));
                  
                  List<Task> tasks =new ArrayList<>();
                  tasks.add(new Task(8, Status.OPEN));
                  tasks.add(new Task(5, Status.OPEN));
                  //tasks.add(new Task(7, Status.OPEN));
                  tasks.add(new Task(10, Status.CLOSED));
                  
                  //calculate total points of only open tasks
                  /* test belongs to Predicate
                   * accept belongs to Consumer
                   */
                  
                  //Make below anonymous functions 
/*                  tasks.stream().filter(new Predicate<Task>() {
                           @Override
                           public boolean test(Task t) {
                                 if (t.getStatus() == Status.OPEN) {
                                       return true;
                                 }
                                 return false;
                           }
                     }).forEach(new Consumer<Task>() {
                           @Override
                           public void accept(Task t) {
                                 System.out.println(t);
                           }
                           
                     });*/
                  
                //stream of tasks
                  tasks.stream().filter((Task t)-> t.getStatus() == Status.OPEN ).forEach((Task t)->   System.out.println(t));
                  
                  //we want to change Task Steam to Integer Stream
                  //Stream<Task>    is getting converted into  Stream<Integer>-Amit
                  tasks.stream().filter((Task t)-> t.getStatus() == Status.OPEN ).mapToInt(new ToIntFunction<Task>() {

                           @Override
                           public int applyAsInt(Task value) {
                                    return value.getPoints();
                                  
                           }
                           
                  });
                  
                  //this gives integer stream
                  //on that Stream<Integer>  ( 8, 5) we are calling terminal operation  eg sum();-Amit

                  int sum = tasks.stream().filter((Task t)-> t.getStatus() == Status.OPEN ).mapToInt
                                    ((Task value)->value.getPoints()).sum();
                  System.out.println(sum);
                  
                  Collections.sort(tasks, new Comparator<Task>() {

                           @Override
                           public int compare(Task o1, Task o2) {
                                    if(o1.getPoints() < o2.getPoints()) {
                                             return 1;
                                    }else if (o1.getPoints() ==o2.getPoints()) {
                                             return 0;
                                    }else {
                                             return -1;
                                    }
                                    
                           }
                  });
                  
                  Collections.sort(tasks, (Task o1, Task o2) -> {
                  
                        if(o1.getPoints() < o2.getPoints()) {
                                 return 1;
                        }else if (o1.getPoints() ==o2.getPoints()) {
                                 return 0;
                        }else {
                                 return -1;
                        }
                  });
                  tasks.forEach((n)->System.out.println(n));
         }

}
