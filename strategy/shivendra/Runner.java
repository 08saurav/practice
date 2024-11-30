package strategy.shivendra;

public class Runner {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        // Pay using Credit Card
        paymentProcessor.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        paymentProcessor.processPayment(100.50);

        // Pay using PayPal
        paymentProcessor.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        paymentProcessor.processPayment(200.75);

        // Pay using Cryptocurrency
        paymentProcessor.setPaymentStrategy(new CryptoPayment("1A2b3C4d5E6f7G8H9I0j"));
        paymentProcessor.processPayment(300.00);
    }
}

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}

class CryptoPayment implements PaymentStrategy {
    private String walletAddress;

    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Cryptocurrency: " + walletAddress);
    }
}


class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy is not set");
        }
        paymentStrategy.pay(amount);
    }
}
