
package minibankingsystem;

public class SavingAccount extends Account{
    private double interestRate;
    
     public SavingAccount(int accountNumber, String owner, double balance, double interestRate) {
        super(accountNumber, owner, balance);
        this.interestRate = interestRate;
    }
    
    @Override
     public void calculateFees() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest added: " + interest);
    }
     
    @Override
      public void printInfo() {
        super.printInfo();
        System.out.println("Account Type: Saving Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
     
     
}
