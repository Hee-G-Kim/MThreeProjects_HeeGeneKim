import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import banking.account.subclass.FixedDepositAccount;
import banking.account.subclass.SavingsAccount;
import banking.customer.Customer;
import bankingaccount.Account;

public class UserIO {

         public enum AccountType {
                  SavingsAccount, SalaryAccount, FixedDeposit;
         }

         public static ArrayList<Object> ObtainCustomersDetails() {

                  ArrayList<Object> customerDetails = new ArrayList<>();
                  Scanner myObj = new Scanner(System.in);
                  System.out.println("Enter First Name: ");
                  String fname = myObj.nextLine();
                  System.out.println("Enter Last Name: ");
                  String lname = myObj.nextLine();
                  System.out.println("Enter Last Name: ");
                  int age = myObj.nextInt();
                  System.out.println("Enter Last Name: ");
                  int mobileNumber = myObj.nextInt();
                  customerDetails.add(fname);
                  customerDetails.add(lname);
                  customerDetails.add(age);
                  customerDetails.add(mobileNumber);
                  return customerDetails;
         }
//         firstname;
//         private String lastname;
//         private int age;
//         private int  mobileNumber;
//         private Account account;

   public static void main(String[] args) {
            
           
            
            int mimimumBalance=100;
            
            System.out.println("Test Customer===============");
            Customer Customer1 = new Customer("John", "Smith", 34, 902020);
            Customer1.setCustomerId();
            Customer Customer2 = new Customer("John", "Doe", 49, 902020);
            Customer2.setCustomerId();
            Customer Customer3 = new Customer("Jack", "Black", 55, 902020);
            Customer2.setCustomerId();
           
            Customer[] customers = new Customer[3] ;
            customers[0]=Customer1;
            customers[1]=Customer2;
            customers[2]=Customer3;
          
            Account savingsAccount1 = new SavingsAccount(200, "09/06/2022");
            savingsAccount1.setAccountNumber();
             Account[] savingsAccounts1 = new Account[1] ;
            savingsAccounts1[0]=savingsAccount1;
            
            Account salaryAccount1 = new SavingsAccount(1000, null, true);
            salaryAccount1.setAccountNumber();
             //Account[] salaryAccounts1 = new Account[1] ;
             //salaryAccounts1[0]=salaryAccount1;
            
          
                  
           Account fixedDepositAccount1 = new FixedDepositAccount(100, "09/06/2022");
           Account fixedDepositAccount2 = new FixedDepositAccount(200, "09/06/2022");
           fixedDepositAccount1.setAccountNumber();
           fixedDepositAccount2.setAccountNumber();
           
           //Account[] fixedDepositAccounts1 = new Account[4] ;
            //fixedDepositAccounts1[0]=fixedDepositAccount1;
            //fixedDepositAccounts1[1]=fixedDepositAccount2;
          
           
            Customer1.setAccount(savingsAccount1);
            Customer1.setAccount(fixedDepositAccount1);
            Customer1.setAccount(fixedDepositAccount2);
            
            Customer3.setAccount(salaryAccount1);
            
            for (int i = 0; i < customers.length; i++) {
                    //System.out.println(customers[i]);
                    System.out.println(customers[i].getFirstname()+ "'s Account Details: " 
                    +customers[i].getAccount()
                  );
            }
            System.out.println("USER I/O===============================");
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter Account Type to create: ");
            String accountType = myObj.nextLine(); 
            
            
            
            
            
            System.out.println("Enter deposit amount: ");
            int openingBalance = myObj.nextInt();
            ArrayList<Object> customerDetails= new ArrayList<>();;
            if(accountType == AccountType.SavingsAccount.toString() &&
                                       openingBalance >= mimimumBalance) 
            {
                     customerDetails= ObtainCustomersDetails();
//                     Customer cus1 = new Customer( customerDetails.get(0),
//                                        customerDetails.get(1),
//                                        customerDetails.get(2),
//                                        customerDetails.get(3))
//                                       );
                     
            }else if (accountType == AccountType.SalaryAccount.toString())
            {
                     
                     customerDetails= ObtainCustomersDetails();
                     Customer cus1 = new Customer();
                     
                     }
            else if(accountType == AccountType.SavingsAccount.toString() &&
                              openingBalance >= mimimumBalance) {
                     
                     System.out.println("Sorry deposit ampunt does"
                                       + " not meet min balance of 100");
            };
   
   }
}
/*
 * public static void main(String[] args) {
 * 
 * Customer Customer1 = new Customer("Jeff", "Scholloson", 34, 902020);
 * Customer1.setCustomerId(); Customer Customer2 = new Customer("Chip", "Koon",
 * 34, 902020); Customer2.setCustomerId();
 * 
 * System.out.println("printCustomers----------------------");
 * 
 * Customer[] customers = new Customer[2] ; customers[0]=Customer1;
 * customers[1]=Customer2; for (int i = 0; i < customers.length; i++) {
 * System.out.println(customers[i]); //
 * System.out.println(customers[i].getFirstname()+ ": "
 * +customers[i].getCustomerId()); }
 * 
 * System.out.println("Savings Account details----------------------");
 * 
 * Account savingsAccount1 = new SavingsAccount(100, "09/06/2022");
 * savingsAccount1.setAccountNumber(); Account[] savingsAccounts1 = new
 * Account[1] ; savingsAccounts1[0]=savingsAccount1;
 * 
 * for (int i = 0; i < savingsAccounts1.length; i++) {
 * System.out.println("savingsAccounts1" + savingsAccounts1[i]); }
 * 
 * System.out.println("Fixed Depost Account details----------------------");
 * 
 * Account fixedDepositAccount1 = new FixedDepositAccount(100, "09/06/2022");
 * Account fixedDepositAccount2 = new FixedDepositAccount(200, "09/06/2022");
 * fixedDepositAccount1.setAccountNumber();
 * fixedDepositAccount2.setAccountNumber();
 * 
 * Account[] fixedDepositAccounts1 = new Account[4] ;
 * fixedDepositAccounts1[0]=fixedDepositAccount1;
 * fixedDepositAccounts1[1]=fixedDepositAccount2; for (int i = 0; i <
 * fixedDepositAccounts1.length; i++) {
 * System.out.println("fixedDepositAccounts " +i + ":"+
 * fixedDepositAccounts1[i]); }
 * 
 * System.out.println("Customers Account  details----------------------");
 * 
 * Customer1.setAccount(savingsAccount1);
 * Customer1.setAccount(fixedDepositAccount1);
 * Customer1.setAccount(fixedDepositAccount2);
 * 
 * for (int i = 0; i < customers.length; i++) {
 * //System.out.println(customers[i]);
 * System.out.println(customers[i].getFirstname()+ "'s Account Details: "
 * +customers[i].getAccount()); }
 * 
 * 
 * }
 */
