package minibankingsystem;

public class CurrentAccount extends Account{
 private double withdrawFee;

   public CurrentAccount(int accountNumber, String owner, double balance, double withdrawFee) {
        super(accountNumber, owner, balance);
        this.withdrawFee = withdrawFee;
    }

 @Override
   public void withdraw(double amount) {
    double total = amount + withdrawFee;
    if (amount > 0 && getBalance() >= total) {   
        setBalance(getBalance() - total);        
        System.out.println(amount + " withdrawn with fee " + withdrawFee);
    } else {
        System.out.println("Insufficient balance for withdraw ");
    }
}
   
    @Override
    public void calculateFees() {
        System.out.println("Current Account fee: " + withdrawFee);
    }
    
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Account Type: Current Account");
        System.out.println("Withdraw Fee: " + withdrawFee);
    }
 
 
 
    
}
