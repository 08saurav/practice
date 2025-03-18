package MiniWallet.models;

//import java.util.Date;
//
//public class Transaction {
//    private String sender;
//    private String receiver;
//    private double amount;
//    private Date timestamp;
//
//    public Transaction(String sender, String receiver, double amount) {
//        this.sender = sender;
//        this.receiver = receiver;
//        this.amount = amount;
//        this.timestamp = new Date();
//    }
//
//    public String getSender() { return sender; }
//    public String getReceiver() { return receiver; }
//    public double getAmount() { return amount; }
//    public Date getTimestamp() { return timestamp; }
//}
import java.time.LocalDateTime;

public class Transaction {
    private String sender;
    private String receiver;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public double getAmount() { return amount; }
    public LocalDateTime getTimestamp() { return timestamp; }
}