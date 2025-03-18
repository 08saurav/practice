//package MiniWallet;
//
//import MiniWallet.controllers.WalletController;
//
//public class Client {
//    WalletController controller = new WalletController();
//    controller.execute();
//}

package MiniWallet;

import MiniWallet.controllers.WalletController;

public class Client {
    public static void main(String[] args) {
        WalletController controller = new WalletController();
        controller.execute();
    }
}
