import javax.ejb.Remote;

@Remote
public interface TransactionBeanRemote {

    void deposit(double amount);

    void withdraw(double amount);

    double getAccountBalance();
}