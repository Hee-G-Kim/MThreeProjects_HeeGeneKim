import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileHandlingDemo {
         //File input stream is the abstract Parent class >  FileInputStream is the child etc
       //File input stream is the abstract Parent class >  FileInputStream is the child etc
       //File input stream is the abstract Parent class >  FileInputStream is the child etc
       //File input stream is the abstract Parent class >  FileInputStream is the child etc
         //Source - File
         //Destination - Console

         public static void main(String[] args) {
                  //Reader is = null;
                  //Writer w=null;
                  InputStream is = null; 
                  OutputStream out= null;
                  BufferedInputStream bis = null;
                  BufferedOutputStream bos = null;
                  System.out.println("File copying started");
                  long starttime =System.currentTimeMillis();
                  try {
                           File f =new File("C:\\MthreeTrainingProjects\\JavaDemos\\nature.jpg");
                           //boolean
                           System.out.println("Is it a folder: "+ f.isDirectory());
                           File f1 =new File("C:\\MthreeTrainingProjects\\JavaDemos\\MyFolder");
                           f1.mkdir();
                           //f1.delete();
                           
                           //InputStream inputstream = new FileInputStream("C:\\MthreeTrainingProjects\\JavaDemos\\somefile.txt");
                           //is = new FileReader("C:\\MthreeTrainingProjects\\JavaDemos\\somefile.txt");
                           is = new FileInputStream("C:\\MthreeTrainingProjects\\JavaDemos\\nature.jpg");
                           out = new FileOutputStream("C:\\MthreeTrainingProjects\\JavaDemos\\newnature.jpg");
                           bis=new BufferedInputStream(is);
                           bos = new BufferedOutputStream(out);
                           while (true) {
                                    //int x = inputstream.read();
                                    int x = bis.read();
                                    if(x==-1) {
                                             break;
                                    }else {
                                             bos.write(x);
                                             //System.out.print((char)x);
                                    }
                           }
                  } catch (FileNotFoundException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }catch (IOException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                           }finally {
                                    try {
                                             bis.close();
                                             bos.close();
                                    } catch (IOException e) {
                                             // TODO Auto-generated catch block
                                             e.printStackTrace();
                                    }
                           }
                  System.out.println("File copied succesfully");
                  long endtime =System.currentTimeMillis();
                  
                  System.out.println(endtime-starttime);

         }
}
