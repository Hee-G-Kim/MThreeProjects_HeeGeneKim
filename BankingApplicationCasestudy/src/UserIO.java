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

         public static Customer obtainCustomersDetails(double openingBalance, String accountType) {

                  Customer customerDetails = new Customer();
                  Scanner myObj = new Scanner(System.in);
                  System.out.println("Enter First Name: ");
                  String fname = myObj.nextLine();
                  System.out.println("Enter Last Name: ");
                  String lname = myObj.nextLine();
                  System.out.println("Enter Age: ");
                  int age = myObj.nextInt();
                  System.out.println("Enter mobile number: ");
                  int mobileNumber = myObj.nextInt();
                  customerDetails.setFirstname(fname);
                  customerDetails.setLastname(lname);
                  customerDetails.setAge(age);
                  customerDetails.setMobileNumber(mobileNumber);
                  
                  Account account = getAccountDetails(openingBalance, accountType);
                  customerDetails.setAccount(account);
                
                  return customerDetails;
         }
         
         public static Account getAccountDetails(double openingBalance, String accountType) {

             Customer customerDetails = new Customer();
             Scanner myObj = new Scanner(System.in);
             System.out.println("Enter opening date: ");
             String openingDate = myObj.nextLine();
             
             if(accountType.equals(AccountType.SavingsAccount.toString())) {
            	 Account account = new SavingsAccount(openingBalance, openingDate);
                 return account;
             }
             return null;
            
    }
   public static void main(String[] args) {
          
            int mimimumBalance=100;
//            
//            System.out.println("Test Customer===============");
//            Customer Customer1 = new Customer("John", "Smith", 34, 902020);
//            Customer1.setCustomerId();
//            Customer Customer2 = new Customer("John", "Doe", 49, 90233);
//            Customer2.setCustomerId();
//            Customer Customer3 = new Customer("Jack", "Black", 55, 902770);
//            Customer2.setCustomerId();
//           
//            Customer[] customers = new Customer[3] ;
//            customers[0]=Customer1;
//            customers[1]=Customer2;
//            customers[2]=Customer3;
//          
//            Account savingsAccount1 = new SavingsAccount(200, "09/06/2022");
//            savingsAccount1.setAccountNumber();
//             Account[] savingsAccounts1 = new Account[1] ;
//            savingsAccounts1[0]=savingsAccount1;
//            
//            Account salaryAccount1 = new SavingsAccount(1000, null, true);
//            salaryAccount1.setAccountNumber();
//       
//          
//                  
//           Account fixedDepositAccount1 = new FixedDepositAccount(100, "09/06/2022");
//           Account fixedDepositAccount2 = new FixedDepositAccount(200, "09/06/2022");
//           fixedDepositAccount1.setAccountNumber();
//           fixedDepositAccount2.setAccountNumber();
//           
//        
//          
//           
//            Customer1.setAccount(savingsAccount1);
//            Customer1.setAccount(fixedDepositAccount1);
//            Customer1.setAccount(fixedDepositAccount2);
//            
//            Customer3.setAccount(salaryAccount1);
//            
//            for (int i = 0; i < customers.length; i++) {
//                    //System.out.println(customers[i]);
//                    System.out.println(customers[i].getFirstname()+ "'s Account Details: " 
//                    +customers[i].getAccount()
//                  );
//            }
            System.out.println("USER I/O===============================");
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter Account Type to create: ");
            String accountType = myObj.nextLine(); 
            
            
            
            System.out.println("Enter deposit amount: ");
            int openingBalance = myObj.nextInt();
            //ArrayList<Object> customerDetails= new ArrayList<>();;
            ArrayList<Customer> customerList= new ArrayList<>();;
            
            if(accountType.equals(AccountType.SavingsAccount.toString())  &&
                                       openingBalance >= mimimumBalance) 
            {
                     
                     
                     customerList.add(obtainCustomersDetails( openingBalance,  accountType));
                     System.out.println(customerList);
             
            }else if (accountType.equals(AccountType.SalaryAccount.toString()) )
            {
                     
            	     customerList.add(obtainCustomersDetails( openingBalance,  accountType));
                     Customer cus1 = new Customer();
                     
                     }
            else if(accountType.equals(AccountType.SavingsAccount.toString()) &&
                              openingBalance <= mimimumBalance) {
                     
                     System.out.println("Sorry deposit amount does"
                                       + " not meet min balance of 100");
            };
   
   }
}
