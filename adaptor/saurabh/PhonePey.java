package adaptor.saurabh;

public class PhonePey {
    // YesBankApI yesyBankApi;
    BankAPI bankAPI;
    PhonePey(YesBankAPI yesyBankApi){
        // this.bankAPI = yesyBankApi;
        // yesyBankApi = new YesBankApI(); // Dependency Injection
    }
    PhonePey(BankAPI bankAPI){
        this.bankAPI = bankAPI;
    }
}
