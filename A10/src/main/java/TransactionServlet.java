import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {

    @EJB
    private TransactionBeanRemote transactionBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        double balance = transactionBean.getAccountBalance();
        out.println("Current Account Balance: $" + balance);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        double amount = Double.parseDouble(request.getParameter("amount"));
        PrintWriter out = response.getWriter();

        try {
            if ("deposit".equals(action)) {
                transactionBean.deposit(amount);
                out.println("Deposit of $" + amount + " successful.");
            } else if ("withdraw".equals(action)) {
                transactionBean.withdraw(amount);
                out.println("Withdrawal of $" + amount + " successful.");
            } else {
                out.println("Invalid action.");
            }
        } catch (IllegalArgumentException e) {
            out.println("Error: " + e.getMessage());
        }
    }
}