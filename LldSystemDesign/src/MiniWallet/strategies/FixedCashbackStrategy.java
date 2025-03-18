package MiniWallet.strategies;

import MiniWallet.models.WalletUser;

public class FixedCashbackStrategy implements CashbackStrategy {
    private static final double CASHBACK_AMOUNT = 10.0;
    private static final int TRANSACTION_THRESHOLD = 5;

    @Override
    public double calculateCashback(WalletUser user, double amount) {
        // After each 5 transactions, provide cashback
        // Check if this transaction is a multiple of 5
        if (user.getTransactionCount() > 0 &&
                (user.getTransactionCount() + 1) % TRANSACTION_THRESHOLD == 0) {
            return CASHBACK_AMOUNT;
        }
        return 0.0;
    }
}
