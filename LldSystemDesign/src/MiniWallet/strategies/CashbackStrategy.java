package MiniWallet.strategies;

import MiniWallet.models.WalletUser;

public interface CashbackStrategy {
    double calculateCashback(WalletUser user, double amount);
}
