
package minibankingsystem;
import java.util.Scanner;

public class Account {
    protected int accountNumber;
    protected String owner;
    protected double balance;

    public Account(int accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
   public void deposit(double amount) {
    if (amount > 0) {
        setBalance(getBalance() + amount); 
        System.out.println(amount + " deposited successfully!");
    } else {
        System.out.println("Invalid deposit amount.");
    }
}
   
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            setBalance(getBalance() - amount);
            System.out.println(amount + " withdrawn successfully!");
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance.");
        }
    }
   
    public void calculateFees() {
        System.out.println("No fees for base Account.");
    }

    public void printInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner: " + owner);
        System.out.println("Balance: " + balance); 
    
    
    
}
}