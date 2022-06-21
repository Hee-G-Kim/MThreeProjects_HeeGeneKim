import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Address implements Serializable{
         private String country;
         private String city;
         
         public Address(String country, String city) {
                  this.country =country;
                  this.city = city;
         }
         @Override
         public String toString() {
                  return country + ", City=" + city;
         }
}

class Student  implements Serializable{
         private int studentId;
         private transient String Name;
         private Address addr;
         
         
         /**
          * @return the addr
          */
         public Address getAddr() {
                  return addr;
         }
         /**
          * @param addr the addr to set
          */
         public void setAddr(Address addr) {
                  this.addr = addr;
         }
         public Student() {
                  
         }
         public Student(int studentId, String name) {
                  super();
                  this.studentId = studentId;
                  Name = name;
                  System.out.println("Inside parametized student constructor");
         }
         @Override
         public String toString() {
                  return studentId + ", Name=" + Name + " " + addr;
         }
         
         
}        

public class SerializationDemo {

         public static void main(String[] args) {
                  
                  Student s1 = new Student(10 ,"Ben");
                  Address a1 = new Address("australia", "Sydney");
                  s1.setAddr(a1);
                  
                  FileOutputStream fos  =null;
                  BufferedOutputStream bos = null;
                  ObjectOutputStream  oos = null;
                  
                  try {
                             fos = new FileOutputStream("C:\\MthreeTrainingProjects\\JavaDemos\\student.ser");
                             bos = new  BufferedOutputStream(fos);
                             oos = new ObjectOutputStream(bos);
                             oos.writeObject(s1);
                             
                  } catch (FileNotFoundException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }catch (IOException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }finally {
                           try {
                                    oos.close();
                           } catch (IOException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                           }
                  }
                  
         }

}
