package MiniWallet.strategies;

import MiniWallet.models.WalletUser;

public class RandomCashbackStrategy implements CashbackStrategy {
    @Override
    public double calculateCashback(WalletUser user, double amount) {
        return Math.random() < 0.5 ? 10 : 0;
    }
}
