package solidprinciple.shivendra;

public class SolidPrinciple {

    public static void main(String[] args) {
        A a = new B();
        a.f("Testing");
        System.out.println("Testing");
        Order o = new Order(new CreditCard());
        o.payment();
    }
    
}

// Bad Example

abstract class Payment {
    // Bad Example
    // public void paymentViaCreditCard() {

    // }
    // public void paymentViaDebitCard() {

    // }

    public int getRewards() {
        return 10;
    }

    // Good Example
    public abstract void payment();

}

class CreditCard extends  Payment {
    public void payment() {

    }
}

class DebitCard extends  Payment {
    public void payment() {

    }
}



class A {

    public void f(String saurabh) {

    }

}

class B extends A {
    @Override
    public void f(String shivendra) {
        // This should not be done.
        // throw new IllegalStateException("vghj");
    }

}

interface PaymentService {
    public void payViaRewards();
    public void payViaUPI();
    public void payViaCreditCard();
}

interface CreditCardInterface {
    public void payViaCrediCard();
}

interface RewardInterface {
    public void payViaRewards();
}

interface UPIInterface {
    public void payViaUPI();
}

class CreditCardService implements CreditCardInterface {
    public void payViaCrediCard() {
        // Payment Logic.

    }
}

class UPIServiceGood implements UPIInterface {
    public void payViaUPI() {

    }
}

class UPIService implements PaymentService {
    public void payViaRewards() {
        // throw new IllegalStateException("vghj");
    }
    public void payViaUPI() {
        

    }
    public void payViaCreditCard() {
        // throw new IllegalStateException("vghj");

    }
}

class RewardService implements PaymentService {
    public void payViaRewards() {
        
    }
    public void payViaUPI() {
        // throw new IllegalStateException("vghj");

    }
    public void payViaCreditCard() {
        // throw new IllegalStateException("vghj");

    }
}


/**
 * S : Single Responsibility for a class
 * O : Open For Extension / Closed For Modification of class
 * L : Liskov Substitution Principle: Suppose we have class A who has class B as its subtype,
 *                                    then in code if we replace Object of A with Object of B then there won't be any anomalies in the code.
 *                                    Subclass Should enhance the capability of parent class not narrow it down.
 * I : Interface Segregation Principle : Classes Implementing interface have to implement only those methods those are relevant to them not all.
 * D : Dependency Inversion : In our codebase we should not have definitions of Concrete classes Instead we should have interface as definiton
 */

class Order {
    // CreditCard c;
    // DebitCard d;
    Payment pay;

    Order(Payment pay) {
        this.pay = pay;
    }

    public void payment() {
        pay.payment();

        // switch (type) {
        //     "credit" : c.payment();

        // }
    }
}