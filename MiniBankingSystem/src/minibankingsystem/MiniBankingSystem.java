package minibankingsystem;

import java.util.Scanner;

public class MiniBankingSystem {

    public static void main(String[] args) {
        
       Scanner s= new Scanner(System.in);
       Bank bank = new Bank();
       boolean exit =false;
       
       while (!exit){
        System.out.println("\n=== Mini Banking System ===");
            System.out.println("1. Add Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            String choice=s.nextLine();
            switch(choice){
                case "1":
                    addAccounttMenu(bank,s);
                    break;
                case "2":
                    bank.displayAllAccounts();
                    break;
                case "3":
                    depositMenu(bank,s);
                    break;
                case "4":
                    withdrawMenu(bank, s);
                    break;
                case "5":
                    transferMenu(bank,s);
                    break;
                case "6":
                    exit=true;
                    System.out.println("Exiting ... GoodBye!!!");
                    break;
                default:
                    System.out.println("Please Choice From Menu Just!!");
            }

       }
       s.close();
    }
    public static void addAccounttMenu(Bank bank, Scanner s){
        System.out.println("Enter Account Number");
        int accNum = getValidInt(s);
        
        System.out.println("Enter Owner Name: ");
        String owner=s.nextLine();
        
        System.out.println("Enter Initial Balance: ");
        double balance=getValidDouble(s);
        
        System.out.println("Choose account type:");
        System.out.println("1. Saving Account");
        System.out.println("2. Current Account");
        System.out.println("3. Loan Account");
        System.out.print("Choice: ");
        String type = s.nextLine();
        
        switch(type){
            case "1":
                System.out.println("Enter Interest Rate :");
                double interest=getValidDouble(s);
                bank.addAccount(new SavingAccount(accNum,owner,balance,interest));
                break;
            case "2":
                System.out.println("Enter Withdraw Fee: ");
                double fee= getValidDouble(s);
                bank.addAccount(new CurrentAccount(accNum, owner, balance,fee));
                break;
            case "3":
                System.out.println("Enter Max Withdrawal Amount: ");
                double max= getValidDouble(s);
                bank.addAccount(new LoanAccount(accNum,owner,balance,max));
                break;
            default:
                System.out.println("Invalid Type!!");
        }
    }
    
    public static void depositMenu(Bank bank, Scanner s){
           System.out.println("Enter Account Number ");
           int accNum=getValidInt(s);
           System.out.println("Enter Deposit Amount");
           double amount = getValidDouble(s);
           bank.depositToAccount(accNum, amount);
       }
       
       public static void withdrawMenu(Bank bank, Scanner s) {
        System.out.print("Enter Account Number: ");
        int accNum = getValidInt(s);
        System.out.print("Enter Withdraw Amount: ");
        double amount = getValidDouble(s);
        bank.withdrawFromAccount(accNum, amount);
    }
       public static void transferMenu(Bank bank, Scanner s){
           System.out.println("Enter Source Account Number :");
           int formAcc = getValidInt(s);
           System.out.println("Enter Destination Account Number: ");
           int toAcc= getValidInt(s);
           System.out.println("Enter Amount To Transfer: ");
           double amount = getValidDouble(s);
           bank.transfer(formAcc, toAcc, amount);
           
       }
       public static int getValidInt(Scanner s){
           while (true){
               String input =s.nextLine();
               try{
                   return Integer.parseInt(input);
               }
               catch(NumberFormatException e){
                   System.out.println("Enter Valid Integer Number:");
               }
           }
       }
       public static double getValidDouble(Scanner s){
           while(true){
               String input=s.nextLine();
               try{
                   return Double.parseDouble(input);
               }
               catch(NumberFormatException e){
                   System.out.println("Invalid Input , Try Again");
               }
           }
       }
       
       
       
    }

    
    

