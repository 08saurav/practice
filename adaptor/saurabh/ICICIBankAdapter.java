package adaptor.saurabh;

public class ICICIBankAdapter implements BankAPI{
    ICICIBankAPI iciciBankAPI = new ICICIBankAPI();

    @Override
    public int checkBalance() {
        return iciciBankAPI.findBalance();
    }
    @Override
    public void moneyTransfer() {
        iciciBankAPI.fundTransfer();
    }
}
