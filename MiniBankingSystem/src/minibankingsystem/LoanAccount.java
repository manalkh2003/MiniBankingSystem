package minibankingsystem;


public class LoanAccount extends Account{
    private double maxWithdrawal;

    public LoanAccount(int accountNumber, String owner, double balance, double maxWithdrawal) {
        super(accountNumber, owner, balance);
        this.maxWithdrawal = maxWithdrawal;
    }
    
    
    @Override
public void withdraw(double amount) {
    if (amount > 0 && amount <= maxWithdrawal && getBalance() >= amount) {  // استخدمنا getter
        setBalance(getBalance() - amount);                                  // استخدمنا setter
        System.out.println(amount + " withdrawn from Loan Account.");
    } else {
        System.out.println("Invalid amount or exceeds max withdrawal limit.");
    }
}
   
     @Override
    public void calculateFees() {
        System.out.println("Loan account has no fees but max withdrawal is " + maxWithdrawal);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Account Type: Loan Account");
        System.out.println("Max Withdrawal: " + maxWithdrawal);
    }
    
}
