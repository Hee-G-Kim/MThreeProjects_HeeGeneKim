package banking.customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bankingaccount.Account;

public  class Customer {
                  
                  private long customerId;
                  private String firstname;
                  private String lastname;
                  private int age;
                  private int  mobileNumber;
                  private Account account;
                  
                  private static long idCounter = 0;
                  
                  public Customer() {
                           
                  }
                  
                  public Customer( String firstname, String lastname, 
                                    int age, int mobileNumber) {
                	  
                	  		super();
                	  		setCustomerId();
                           this.firstname = firstname;
                           this.lastname = lastname;
                           this.age = age;
                           this.mobileNumber = mobileNumber;
                  }

                  public long getCustomerId() {
                           return customerId;
                  }
                  public void setCustomerId() {
                           //String customerId = UUID.randomUUID().toString();
                           long customerId = createID();
                           this.customerId = customerId;
                  }
                  public String getFirstname() {
                           return firstname;
                  }
                  public void setFirstname(String firstname) {
                           firstname = CheckNameValidation(firstname);
                           this.firstname = firstname;
                  }
                  private String CheckNameValidation(String fn) {
                           
                           Pattern p = Pattern.compile( "[^a-z0-9 ]", 
                                             Pattern.CASE_INSENSITIVE);
                           // Creating matcher for above pattern on  string
                           Matcher m = p.matcher(fn);
                
                           boolean res = m.find();
                    
                           // Output will be based on boolean flag
                           // If special characters are found
                           if (res) {
                               System.out.println(
                                   "firstname contains Special Characters");
                           return null;}
                           else {
                               System.out.println(
                                   "Your input is fine");
                               return fn;
                           }   
                  }
                  
                  public String getLastname() {
                           return lastname;
                  }
                  public void setLastname(String lastname) {
                           firstname = CheckNameValidation(lastname);
                           this.lastname = lastname;
                  }
                  public int getAge() {
                           return age;
                  }
                  public void setAge(int age) {
                           this.age = age;
                  }
                  public int getMobileNumber() {
                           return mobileNumber;
                  }
                  public void setMobileNumber(int mobileNumber) {
                           this.mobileNumber = mobileNumber;
                  }
                  
                  public Account getAccount() {
                           return account;
                  }

                  public void setAccount(Account account) {
                           this.account = account;
                  }







                  @Override
                  public String toString() {
                           return "Customer Details:- customerId: " + customerId + ", firstname: " + firstname + ", lastname: "
                                             + lastname + ", age: " + age + ", mobileNumber: " + mobileNumber + account;
                  }







                  public static long createID()
                  {
                      return ++idCounter;
                  }  
                  
}
