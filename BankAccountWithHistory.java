// BankAccount with transaction history returning an unmodifiable list for safety.
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccountWithHistory {
    private final String accountNumber;
    private String ownerName;
    private double balance;
    private final List<String> transactions = new ArrayList<>();

    public BankAccountWithHistory(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = openingBalance;
        transactions.add(String.format("Account opened with balance: $%.2f", openingBalance));
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        transactions.add(String.format("Deposited: $%.2f | New Balance: $%.2f", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            transactions.add(String.format("Declined withdrawal: $%.2f (Insufficient funds)", amount));
            return false;
        }
        balance -= amount;
        transactions.add(String.format("Withdrew: $%.2f | New Balance: $%.2f", amount, balance));
        return true;
    }

    // Returns an unmodifiable view to preserve defensive encapsulation
    public List<String> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccountWithHistory acc = new BankAccountWithHistory("ZW-9021", "Anesu Kahanda", 1000.0);
        acc.deposit(350.0);
        acc.withdraw(120.0);
        acc.withdraw(5000.0); // Will be declined

        System.out.println("--- Transaction History ---");
        for (String entry : acc.getTransactions()) {
            System.out.println("- " + entry);
        }

        // Proving that outside modification is rejected
        try {
            acc.getTransactions().add("Fake deposit: $10,000");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nSecurity verified: Direct modification of transaction history is blocked.");
        }
    }
}
