package MiniWallet.models;

import java.util.*;

public class WalletUser {
    private String name;
    private double balance;
    private List<Transaction> transactions;
    private double cashbackEarned;
    private int transactionCount;

    public WalletUser(String name) {
        this.name = name;
        this.balance = 0;
        this.transactions = new ArrayList<>();
        this.cashbackEarned = 0;
        this.transactionCount = 0;
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }
    public void addBalance(double amount) { balance += amount; }
    public void deductBalance(double amount) { balance -= amount; }
    public List<Transaction> getTransactions() { return transactions; }
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transactionCount++;
    }
    public void addCashback(double amount) {
        cashbackEarned += amount;
        balance += amount;
    }
    public double getCashbackEarned() { return cashbackEarned; }
    public int getTransactionCount() { return transactionCount; }
}

