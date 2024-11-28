package adaptor.saurabh;

public class YesBankAdapter implements BankAPI{
    YesBankAPI yesBankAPI = new YesBankAPI();
    @Override
    public int checkBalance() {
        return yesBankAPI.getBalance();
    }
    @Override
    public void moneyTransfer() {
        yesBankAPI.deposit();
    }
}
    
