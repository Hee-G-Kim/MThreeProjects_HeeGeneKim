import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbDemo {

         //Step 1. Load  the Driver Class in to memory mysql, 
         //e,g this class? as per the the code inside driver, the driver 
         //will be registered itself with the DriverManager Class(a java class)
         //Step2. From DriverManager get the connection
         //Step3.From the connection get the STATEMENT
         //Step4 the STATAMENT get the RESULTSET
         //Step5. Print he dat fro the resukt set
         
//         hard coding ?
//                           4 things are hard coded in our current DBDemo
//                           1.  name of the driver class
//                           2. URL
//                           2. username
//                           4. password
 //       in dbconfig.properties


         public static void main(String[] args) {
                  
                  
                  try {
                           Class.forName("com.mysql.jdbc.Driver");/*Step 1 .Driver is written by mysql 
                           and contained in *JAR* file*/
                           //Whatever static block are there in Driver.jav will get executed"
                           //As for that logic the Driver will get registered itself to DriverManager
                           
                          /*here its like Interface-Pet dog = new Dog(); poly
                           * morphism*/
                           /*--getConnection(url) cages depending on above JAR File
                            :MySQL specific URLOracle specific URL
                            --DriverManager is  a Java File  */
                           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root");
                           System.out.println(con);
                           
                           String sql ="INSERT into employee(id, fname, lname) VALUES(99, 'Ron', 'McDonald')";
                           //con.createStatement(sql);
                           Statement stat = con.createStatement();
                           
//                        String insert ="INSERT into employee(id, fname, lname) VALUES(20, 'Harvey', 'Singh')";
//                        Statement stat = con.createStatement();
                           stat.executeUpdate(sql);
                           
                           String select ="select * from employee";
                           ResultSet result = stat.executeQuery(select);
                           
                           while(result.next()) {
                                    int id =result.getInt("id");
                                    String fname =result.getString("fname");
                                    String lname =result.getString("lname");
                                    System.out.println(id+fname+lname);
                           }
                           PreparedStatement pstat1 = con.prepareStatement("INSERT INTO "
                                             + "EMP.employee(ID,fname,lname) VALUES(?,?,?)");

                           pstat1.setInt(1, 99);
                           pstat1.setString(2, "Jinny");
                           pstat1.setString(3, "Maki");
                           pstat1.execute();
                           
                           /*Callable statement=extends from prepared statement- and is used for strored procedure*/
                           
                  } catch (SQLException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  } catch (ClassNotFoundException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                  }
//                  finally {
//                           try {
//                                    con.close();
//                           } catch (SQLException e) {
//                                    // TODO Auto-generated catch block
//                                    e.printStackTrace();
//                           }
//                  }
                  
         }

}

//try {
//         Class.forName("com.mysql.jdbc.Driver");//Step 1 .Driver is written by mysql 
//         //and contained in jar file
//         DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","root"); //get connection is a static method
//} catch (ClassNotFoundException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//}
//Connection con =null;
