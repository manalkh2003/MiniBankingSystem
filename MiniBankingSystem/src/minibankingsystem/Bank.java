package minibankingsystem;

import java.util.ArrayList;

public class Bank {
 private ArrayList<Account> accounts;
 
 public Bank(){
     accounts =new ArrayList<>();
 }
 
public void addAccount(Account account) {

    for (Account acc : accounts) {
        if (acc.getAccountNumber() == account.getAccountNumber()) {
            System.out.println("Account number already exists!");
            return;
        }
    }

    accounts.add(account);
    System.out.println("Account added successfully!");
}

    public Account findAccountByNumber(int accountNumber){
      for(Account acc:accounts)
      {
       if(acc.getAccountNumber()== accountNumber){
           return acc;
       }   
      }
      return null;
    }
     
    
     public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (Account acc : accounts) {
                acc.printInfo();
                System.out.println("---------------------------");
            }
        }
    }

   public void depositToAccount(int accountNumber, double amount) {
        Account acc = findAccountByNumber(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
   
  public void withdrawFromAccount(int accountNumber, double amount) {
        Account acc = findAccountByNumber(accountNumber);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
  
      public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        Account fromAcc = findAccountByNumber(fromAccountNumber);
        Account toAcc = findAccountByNumber(toAccountNumber);

        if (fromAcc == null || toAcc == null) {
            System.out.println("One or both accounts not found.");
            return;
        }

        if (fromAcc.getBalance() >= amount) {
            fromAcc.setBalance(fromAcc.getBalance() - amount);
            toAcc.setBalance(toAcc.getBalance() + amount);
            System.out.println("Transferred " + amount + " from account " 
                               + fromAccountNumber + " to account " + toAccountNumber);
        } 
        else {
            System.out.println("Insufficient balance in the source account.");
        }
    }

    
    
    
    
    
    
}
