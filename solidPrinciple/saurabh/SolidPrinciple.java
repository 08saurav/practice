/**
 * S - > Single Responsiblity Principle 
 * O
 * L
 * I
 * D
 */

 import java.util.ArrayList;
 import java.util.List;

public class SolidPrinciple {
    public static void main(String [] args){
        System.out.println("Testing");
    }
}
//  Bad Example 
/* 
 * Breaking Principles
 * 1. Single Responsiblity Principle -> One class is doing multiple work 
 * 2. Open Closed Principle -> If any other comes into the picture like UPi offer it will lead to change in all other classes
 * 3. Liskov Substitution Principle -> Suppose we have class A who has class B as its subtype,
 *                                    then in code if we replace Object of A with Object of B then there won't be any anomalies in the code.
 *                                    Subclass Should enhance the capability of parent class not narrow it down.
 *  ---------------------------------- Not breaking this principle ------------------------------
 * 4. Interface Segregation Principle -> classes DebitCardOffer implementing Offers needs to write all kinds of offer which are not relevant to them
 *                                         So it's breaking this principle
 * 5. Dependency Inversion Principle -> It focuses on the approach where the higher classes are not dependent on the lower
 *                                       classes instead depend upon the abstraction of the lower classes.
 *      -------------------------------NOT BREAKING THIS PRINCIPLE---------------------------
 */

//  --------------------BAD EXAMPLE -----------------------------------
// interface Offers{
//     public void getCreditCardOffer();
//     public void getDebitCardOffer();
//     // public void getPayPalOffer();
//     // public void getAmazonOffer();
//     // public void getPaytmOffer();
// }
// class DebitCardOffer implements Offers {
//     public void getCreditCardOffer() {
//         // System.out.println("Credit Card Offer: 10% off");
//     }
//     public void getDebitCardOffer() {
//         System.out.println("Debit Card Offer: 5% off");
//     }
// }

// class CreditCardOffer implements Offers {
//     public void getCreditCardOffer() {
//         System.out.println("Credit Card Offer: 15% off");
//     }
//     public void getDebitCardOffer() {
//         // System.out.println("Debit Card Offer: 10% off");
//     }
// }

// ------------- GOOD EXAMPLE -----------------------------------
// interface DebitCardOffer {
//     public void getDebitCardOffer();
// }
// interface CreditCardOffer {
//     public void getCreditCardOffer();
// }
interface Offer {
    public void getOffer();
}

class DebitOffer implements Offer {
    public void getOffer() {
        System.out.println("Debit Card Offer: 5% off");
    }
}

class CreditOffer implements Offer {
    public void getOffer() {
        System.out.println("Credit Card Offer: 15% off");
    }
}

// OPEN CLOSE PRINCIPLE EXAMPLE(Open for extention close for modification)

interface RewardPoints1 {
    public int calculateRewardPoint();
}

class DebitCardReward implements RewardPoints1 {
    @Override
    public int calculateRewardPoint() {
        System.out.println("Calculating reward points for Debit Card...");
        return 20; // Example reward points for Debit cards
    }
}

class CreditCardReward implements RewardPoints1 {
    @Override
    public int calculateRewardPoint() {
        System.out.println("Calculating reward points for Credit Card...");
        return 20; // Example reward points for Credit cards
    }
}

interface RewardPoints {
    public int calculateDebitCardRewardPoint();
    public int calculateCreditCardRewardPoint();
    public int calculatePayPalRewardPoint();
}


/*  LISKOV SUBSTITUTION PRINCIPLE (a subclass should be able to stand in for its parent class without breaking functionality. 
It ensures that the derived classes honor the behavior expected from the base class.) */

// WRONG EXAMPLE

// class Bird {
//     public void fly() {
//         System.out.println("I can fly!");
//     }
// }

// class Sparrow extends Bird {
//     // Sparrow can fly
// }

// class Ostrich extends Bird {
//     // Ostrich cannot fly
//     @Override
//     public void fly() {
//         throw new UnsupportedOperationException("Ostrich cannot fly");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Bird sparrow = new Sparrow();
//         sparrow.fly(); // Output: I can fly!

//         Bird ostrich = new Ostrich();
//         ostrich.fly(); // Throws an exception - Violates LSP
//     }
// }

// right example
// Base class
abstract class Bird {
    public abstract void display();
}

// Birds that can fly
abstract class FlyingBird extends Bird {
    public void fly() {
        System.out.println("I can fly!");
    }
}

// Flying birds
class Sparrow extends FlyingBird {
    @Override
    public void display() {
        System.out.println("I am a Sparrow.");
    }
}

// Non-flying birds
class Ostrich extends Bird {
    @Override
    public void display() {
        System.out.println("I am an Ostrich. I cannot fly.");
    }
}

// public class Main {
//     public static void main(String[] args) {
//         Bird sparrow = new Sparrow();
//         sparrow.display();
//         ((FlyingBird) sparrow).fly(); // Output: I can fly!

//         Bird ostrich = new Ostrich();
//         ostrich.display(); // Output: I am an Ostrich. I cannot fly.
//     }
// }





/*
 * Dependency Inversion Example
 * Here at first class Manager class will change if we add another class which comes under manager class, 
 * in second example manager class doesn't directly know what kind of employee is under manager he just employee which is an abstract class which implements employee behaviour 
 * and all other class implements employee so if new kind of employee comes there is no need to change in manager class 
 * in this way parent is not dependent on child class 
 */

 
 // Manager class
//  class Manager {
//      private List<Developer> developers;
//      private List<Designer> designers;
//      private List<Tester> testers;
 
//      public Manager() {
//          developers = new ArrayList<>();
//          designers = new ArrayList<>();
//          testers = new ArrayList<>();
//      }
 
//      public void addDeveloper(Developer developer) {
//          developers.add(developer);
//          System.out.println("Developer added");
//      }
 
//      public void addDesigner(Designer designer) {
//          designers.add(designer);
//          System.out.println("Designer added");
//      }
 
//      public void addTester(Tester tester) {
//          testers.add(tester);
//          System.out.println("Tester added");
//      }
 
//      // Getter methods if needed
//      public List<Developer> getDevelopers() {
//          return developers;
//      }
 
//      public List<Designer> getDesigners() {
//          return designers;
//      }
 
//      public List<Tester> getTesters() {
//          return testers;
//      }
//  }
 
//  // Developer class
//  class Developer {
//      public Developer() {
//          System.out.println("Developer created");
//      }
//  }
 
//  // Designer class
//  class Designer {
//      public Designer() {
//          System.out.println("Designer created");
//      }
//  }
 
//  // Tester class
//  class Tester {
//      public Tester() {
//          System.out.println("Tester created");
//      }
//  }
 
 // Main class to run the program
//  public class Main {
//      public static void main(String[] args) {
//          Manager manager = new Manager();
 
//          // Adding employees
//          manager.addDeveloper(new Developer());
//          manager.addDesigner(new Designer());
//          manager.addTester(new Tester());
//      }
//  }
 


// Base class
abstract class Employee {
    // Abstract method to be implemented by subclasses
    abstract void work();
}

// Manager class
class Manager {
    private List<Employee> employees;

    public Manager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

// Developer class
class Developer extends Employee {
    public Developer() {
        System.out.println("Developer added");
    }

    @Override
    public void work() {
        System.out.println("Turning coffee into code");
    }
}

// Designer class
class Designer extends Employee {
    public Designer() {
        System.out.println("Designer added");
    }

    @Override
    public void work() {
        System.out.println("Turning lines into wireframes");
    }
}

// Tester class
class Tester extends Employee {
    public Tester() {
        System.out.println("Tester added");
    }

    @Override
    public void work() {
        System.out.println("Testing everything out there");
    }
}

// Main class to run the code
// public class Main {
//     public static void main(String[] args) {
//         Manager manager = new Manager();
        
//         // Adding employees
//         manager.addEmployee(new Developer());
//         manager.addEmployee(new Designer());
//         manager.addEmployee(new Tester());

//         // Employees perform their work
//         for (Employee employee : manager.getEmployees()) {
//             employee.work();
//         }
//     }
// }

// class OfferManager implements Offers{
//     public void CreditCardOffer() {
//         System.out.println("Credit Card Offer: 10% off");
//     }
//     public void DebitCardOffer() {
//         System.out.println("Debit Card Offer: 5% off");
//     }}

// class PaymentProcessor{
//     private Offers offerManager;   

//     public PaymentProcessor(Offers offerManager) {
//         this.offerManager = offerManager;
//     }

//     public void processPayment(String paymentMethod){
//         if(paymentMethod.equalsIgnoreCase("creditCard")){
//             offerManager.CreditCardOffer();
//         } else if(paymentMethod.equalsIgnoreCase("debitCard")){
//             offerManager.DebitCardOffer();
//         } else if(paymentMethod.equalsIgnoreCase("paypal")){
//             offerManager.PayPalOffer();
//         } else if(paymentMethod.equalsIgnoreCase("amazon")){
//             offerManager.AmazonOffer();
//         } else if(paymentMethod.equalsIgnoreCase("paytm")){
//             offerManager.PaytmOffer();
//         } else {
//             System.out.println("Invalid payment method");
//         }
//     }

//     public static void main(String[] args) {    
//          OfferManager offerManager = new OfferManager();
//          PaymentProcessor paymentProcessor = new PaymentProcessor(offerManager);
//          paymentProcessor.processPayment("creditCard");
//     }

//     // Other methods and other classes

// }