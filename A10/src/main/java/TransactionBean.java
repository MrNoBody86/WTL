import javax.ejb.Stateless;

@Stateless
public class TransactionBean {

    private double accountBalance = 0; // Initial account balance

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        accountBalance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > accountBalance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        accountBalance -= amount;
        System.out.println("Withdrawal of $" + amount + " successful.");
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
