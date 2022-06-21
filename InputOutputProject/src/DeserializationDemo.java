import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeserializationDemo {

         public static void main(String[] args) {
                  
                  FileInputStream fis  =null;
                  BufferedInputStream bis = null;
                  ObjectInputStream  ois = null;
                  
                  try {
                           fis = new FileInputStream("C:\\MthreeTrainingProjects\\JavaDemos\\student.ser");
                           bis = new  BufferedInputStream(fis);
                           ois = new ObjectInputStream(bis);
                           
                           Student s1 =(Student)ois.readObject();
                           System.out.println(s1);
                           
                  } catch (FileNotFoundException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  } catch (IOException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }catch (ClassNotFoundException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                           }finally {
                                    try {
                                             ois.close();
                                    } catch (IOException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                                    }
                           }
         }
}
