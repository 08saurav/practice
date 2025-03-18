package MiniWallet.strategies;

import MiniWallet.models.WalletUser;

public class CashbackContext {
    private CashbackStrategy strategy;

    public CashbackContext(CashbackStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(CashbackStrategy strategy) {
        this.strategy = strategy;
    }

    public double getCashback(WalletUser user, double amount) {
        return strategy.calculateCashback(user, amount);
    }
}
