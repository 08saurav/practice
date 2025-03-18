package MiniWallet.services;

import MiniWallet.models.Transaction;
import MiniWallet.models.WalletUser;
import MiniWallet.strategies.CashbackContext;
import MiniWallet.strategies.FixedCashbackStrategy;
import MiniWallet.strategies.RandomCashbackStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletService {
    private static WalletService instance;
    private Map<String, WalletUser> users;
    private CashbackContext cashbackContext;

    private WalletService() {
        users = new HashMap<>();
        // Initialize with Fixed Cashback Strategy by default
        cashbackContext = new CashbackContext(new FixedCashbackStrategy());
    }

    public static WalletService getInstance() {
        if (instance == null) {
            instance = new WalletService();
        }
        return instance;
    }

    // Method to switch between cashback strategies
    public void setCashbackStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("fixed")) {
            cashbackContext.setStrategy(new FixedCashbackStrategy());
        } else if (strategyType.equalsIgnoreCase("random")) {
            cashbackContext.setStrategy(new RandomCashbackStrategy());
        }
    }

    public String registerUser(String name) {
        if (users.containsKey(name)) return "User already registered";
        users.put(name, new WalletUser(name));
        return "User " + name + " is registered";
    }

    public String topUpWallet(String name, double amount) {
        if (!users.containsKey(name)) return "User not registered";
        if (amount <= 0) return "Invalid amount";
        users.get(name).addBalance(amount);
        return name + "'s wallet has credit with " + amount + " Rs successfully";
    }

    public String topUpWallet(String name, String paymentMethod, double amount) {
        if (!users.containsKey(name)) return "User not registered";
        if (amount <= 0) return "Invalid amount";
        users.get(name).addBalance(amount);
        return name + "'s wallet has credit with " + amount + " Rs successfully via " + paymentMethod;
    }

    public String fetchBalance(String name) {
        if (!users.containsKey(name)) return "User " + name + " is not registered";
        return name + "'s wallet has " + users.get(name).getBalance() + " Rs amount";
    }

    public String sendMoney(String sender, String receiver, double amount) {
        if (!users.containsKey(sender) || !users.containsKey(receiver))
            return "Sender or receiver not registered";
        if (amount <= 0) return "Invalid amount";
        if (users.get(sender).getBalance() < amount)
            return sender + " doesn't have sufficient amount to transfer " + amount + " Rs";

        // Deduct amount from sender
        users.get(sender).deductBalance(amount);
        // Add amount to receiver
        users.get(receiver).addBalance(amount);

        // Create and record transaction
        Transaction transaction = new Transaction(sender, receiver, amount);
        users.get(sender).addTransaction(transaction);
        users.get(receiver).addTransaction(transaction);

        // Calculate cashback based on current strategy
        double cashback = cashbackContext.getCashback(users.get(sender), amount);
        if (cashback > 0) {
            users.get(sender).addCashback(cashback);
        }

        // Return appropriate message
        return cashback > 0 ?
                sender + " has transferred " + amount + " Rs amount to " + receiver +
                        " and get cashback of " + cashback + " Rs" :
                sender + " has transferred " + amount + " Rs amount to " + receiver;
    }

    public String getTransactions(String name, String filter, String sorter) {
        if (!users.containsKey(name)) return "User not registered";
        List<Transaction> transactions = users.get(name).getTransactions();

        transactions.sort((a, b) -> sorter.equals("amount") ?
                Double.compare(a.getAmount(), b.getAmount()) : a.getTimestamp().compareTo(b.getTimestamp()));

        StringBuilder result = new StringBuilder();
        for (Transaction t : transactions) {
            if (filter.equals("send") && !t.getSender().equals(name)) continue;
            if (filter.equals("receive") && !t.getReceiver().equals(name)) continue;
            result.append(t.getSender()).append(" -> ").append(t.getReceiver()).append(" : ")
                    .append(t.getAmount()).append(" Rs\n");
        }
        return result.toString();
    }

    public String getCashback(String name) {
        if (!users.containsKey(name)) return "User not registered";
        return name + " got total cashback of " + users.get(name).getCashbackEarned() + " Rs";
    }
}