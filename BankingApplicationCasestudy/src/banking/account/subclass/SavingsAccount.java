package banking.account.subclass;

import bankingaccount.Account;

public class SavingsAccount extends Account implements SalaryAccount {

         private boolean IsSalaryAccount = true;
         private int minBalance = 100;

         public SavingsAccount() {
                  super();

         }

         public SavingsAccount(double balance, String dateOpened) {
                  super(balance, dateOpened);

         }

         public SavingsAccount(double balance, String dateOpened, boolean isSalaryAccount) {

                  this.IsSalaryAccount = isSalaryAccount;
                  if (isSalaryAccount) {
                           minBalance = 0;
                           this.balance = balance;
                  }

                  this.dateOpened = dateOpened;

         }


         public boolean isIsSalaryAccount() {
                  return IsSalaryAccount;
         }

         public void setIsSalaryAccount(boolean isSalaryAccount) {
                  IsSalaryAccount = isSalaryAccount;
         }

         public int getMinBalance() {
                  return minBalance;
         }

         public void setMinBalance(int minBalance) {
                  this.minBalance = minBalance;
         }

         @Override
         public void checkBalance() {
                
         }

}
