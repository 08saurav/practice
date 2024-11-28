package adaptor.saurabh;

public class Runner {
    public static void main(String[] args) {
        BankAPI bankAPI = new ICICIBankAdapter();
        bankAPI.checkBalance();
        bankAPI.moneyTransfer();
        PhonePey phonePe = new PhonePey(new YesBankAPI());

        BankAPI b = new YesBankAdapter();
        PhonePey phonePe1 = new PhonePey(b);

    }
    
}
