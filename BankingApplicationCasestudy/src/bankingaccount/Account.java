package bankingaccount;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;

public abstract class Account {
                  protected long accountNumber;
                  protected double balance=0;
                  protected String dateOpened;
                  
                  public static String bankName= "EastpacBank";
                  public static String branchName= "Strathfield";
                  private static long idCounter = 0;
                  public Account() {
                           
                  }
                  public Account( double balance, String dateOpened) {
                           super();
                           setAccountNumber();
                           this.balance = setBalance(balance);
                            //this.dateOpened = dateOpened;
                           setDateOpened(dateOpened);
                           
                  }
                 

                  public long getAccountNumber() {
                           return accountNumber;
                  }

                  public void setAccountNumber() {
                           long accountNum= createAccountNumber();
                           this.accountNumber= accountNum;
                  }

                  public double getBalance() {
                           return balance;
                  }

                  public double setBalance(double balance) {
                           /*Todo: set up own exception*/
                           if ( balance >= 100) {
                                   return  this.balance = balance;
                           }else {
                                    System.out.println("Balance needs to be miniumum $100");
                                    return balance=0;
                           }
                          
                  }

                  public String getDateOpened() {
                           return dateOpened;
                  }

                  public void setDateOpened(String dateOpened) {
                           this.dateOpened=validateDate(dateOpened);
                           
                  }

                  
                  public static String validateDate(String inputedDate) {
                           //Check for right date format-method
                           ///esc seq in java so need to do twice
                             String[] inputedDateArray=inputedDate.split("/");
                             String day = inputedDateArray[0];
                             int resultDay = Integer.parseInt(day);
                             String month = inputedDateArray[1];
                             int resultMonth = Integer.parseInt(month);
                             String year = inputedDateArray[1];
                             int resultYear = Integer.parseInt(year);
                             
                             
                             //int[] inputedDateArrayInt =new int[3];
//                            
//                             int x=2;
//                             for (int i = 0; i < inputedDateArrayInt.length; i++) {
//                                      String s = inputedDateArray[i];
//                                      int di =Integer.parseInt(s);
//                                      inputedDateArrayInt[i+x] = di;
//                                      x--;
//                             }
                            
                            Boolean answer= isDateValid(resultDay,
                                              resultMonth,resultYear);
                            if(answer) {
                                     //System.out.println("Date valid");
                                     return inputedDate;
                            }
                            else {
                                     //System.out.println("Date is not valid");
                                     return "00/00/00";
                            } 
                    }
//                    public static String removeLeadingZeroes(String str) {
//                             String strPattern = "^0+(?!$)";
//                             str = str.replaceAll(strPattern, "");
//                             return str;
//                          }
                    public static boolean isDateValid(int year, int month, int day) {
                             try {
                                 LocalDate.of(year, month, day);
                             } catch (DateTimeException e) {
                                 return false;
                             }
                             return true;
                         }
                  
                  

                  @Override
                  public String toString() {
                           return "Account Details:- AccountNumber: " + accountNumber + ", Balance: " + balance + ", dateOpened: "
                                             + dateOpened;
                  }
                  public static long createAccountNumber()
                  {
                      return ++idCounter;
                  }  
}
