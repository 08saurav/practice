package MiniWallet.controllers;

import MiniWallet.services.WalletService;

public class WalletController {
    private WalletService walletService;

    public WalletController() {
        walletService = WalletService.getInstance();
    }

    public void execute() {
//        // Main test cases
//        System.out.println(walletService.fetchBalance("Bob"));
//        System.out.println(walletService.registerUser("Bob"));
//        System.out.println(walletService.topUpWallet("Bob", "CC", 1000));
//        System.out.println(walletService.topUpWallet("Bob", "UPI", 100));
//        System.out.println(walletService.fetchBalance("Bob"));
//        System.out.println(walletService.registerUser("Alice"));
//        System.out.println(walletService.topUpWallet("Alice", "CC", 100));
//        System.out.println(walletService.fetchBalance("Alice"));
//        System.out.println(walletService.sendMoney("Bob", "Alice", 1250));
//        System.out.println(walletService.sendMoney("Bob", "Alice", 250));
//        System.out.println(walletService.sendMoney("Alice", "Bob", 50));
//        System.out.println(walletService.fetchBalance("Bob"));
//        System.out.println(walletService.fetchBalance("Alice"));
//        System.out.println(walletService.getTransactions("Bob", "send", "amount"));
//        System.out.println(walletService.getTransactions("Bob", "receive", "time"));
//
//        // BONUS test cases
//        System.out.println("BONUS:");
//        // Reset for the bonus part
//        WalletService bonusService = WalletService.getInstance();
//        // Create users for bonus scenario to match expected output
//        System.out.println(bonusService.registerUser("Bob"));
//        System.out.println(bonusService.registerUser("Alice"));
//        System.out.println(bonusService.topUpWallet("Bob", 1000));
//        System.out.println(bonusService.topUpWallet("Alice", 300));
//
//        // Execute the bonus test cases
//        System.out.println(bonusService.sendMoney("Bob", "Alice", 100));
//        System.out.println(bonusService.getCashback("Bob"));
//        System.out.println(bonusService.fetchBalance("Bob"));
//        System.out.println(bonusService.fetchBalance("Alice"));
//        System.out.println(bonusService.getTransactions("Bob", "send", "amount"));
//        System.out.println(bonusService.getTransactions("Bob", "receive", "time"));
        // Main test cases
        System.out.println(walletService.fetchBalance("Bob"));
        System.out.println();

        System.out.println(walletService.registerUser("Bob"));
        System.out.println(walletService.topUpWallet("Bob", "CC", 1000));
        System.out.println(walletService.topUpWallet("Bob", "UPI", 100));
        System.out.println(walletService.fetchBalance("Bob"));

        System.out.println();

        System.out.println(walletService.registerUser("Alice"));
        System.out.println(walletService.topUpWallet("Alice", "CC", 100));
        System.out.println(walletService.fetchBalance("Alice"));

        System.out.println();

        System.out.println(walletService.sendMoney("Bob", "Alice", 1250));
        System.out.println(walletService.sendMoney("Bob", "Alice", 250));
        System.out.println(walletService.sendMoney("Alice", "Bob", 50));

        System.out.println();

        System.out.println(walletService.fetchBalance("Bob"));
        System.out.println(walletService.fetchBalance("Alice"));

        System.out.println();

        System.out.println(walletService.getTransactions("Bob", "send", "amount"));
        System.out.println(walletService.getTransactions("Bob", "receive", "time"));

        // Example of switching strategies
        // walletService.setCashbackStrategy("random");

        // No bonus part as requested
    }
}
