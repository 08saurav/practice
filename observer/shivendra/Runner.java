package observer.shivendra;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Stock appleStock = new Stock("Apple", 150.00);

        Trader trader1 = new Trader("Trader Joe");
        PortfolioManager portfolioManager = new PortfolioManager();

        appleStock.addObserver(trader1);
        appleStock.addObserver(portfolioManager);

        // Change stock price
        appleStock.setPrice(152.50);
    }
}

/*
 * On State Change of Subject , Observers are notified. subject maintains list
 * of observers to whom they need to notify.
 * Observers needs to implement a Observer interface where they will tell what
 * to do when the state changes.
 */

/*
 * Key Participants
 * Subject: The core object that holds the state and allows observers to
 * register/unregister themselves.
 * Observers: Objects that are notified when the Subject's state changes.
 * Concrete Subject: A specific implementation of the Subject that maintains
 * state.
 * Concrete Observers: Specific implementations of Observers that react to state
 * changes.
 */

interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

interface Observer {
    void update(double price);
}

class Stock implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public Stock(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }
}

class Trader implements Observer {
    private String name;

    public Trader(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println(name + " received price update: " + price);
    }
}

class PortfolioManager implements Observer {
    @Override
    public void update(double price) {
        System.out.println("Portfolio updated with new price: " + price);
    }
}