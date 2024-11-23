package factory.shivendra;

/**
 * Creational Design Pattern Control Creation of Objects
 */


/*
 * Without factory Design Pattern
import java.io.*;

// Library classes
abstract class Vehicle {
    public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am two wheeler");
    }
}

class FourWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("I am four wheeler");
    }
}

// Client (or user) class
class Client {
    private Vehicle pVehicle;

    public Client(int type) {
        if (type == 1) {
            pVehicle = new TwoWheeler();
        } else if (type == 2) {
            pVehicle = new FourWheeler();
        } else {
            pVehicle = null;
        }
    }

    public void cleanup() {
        if (pVehicle != null) {
            pVehicle = null;
        }
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}

// Driver program
public class GFG {
    public static void main(String[] args) {
        Client pClient = new Client(1);
        Vehicle pVehicle = pClient.getVehicle();
        if (pVehicle != null) {
            pVehicle.printVehicle();
        }
        pClient.cleanup();
    }
}
 */


 /*
  * Factory Design Pattern
  * It gives an Interface for creating objects from a superclass
  * When it should be used :
  * It is to be used when type of objects to be created needs to be determined at time of run time or users input.
  * This pattern simplifies the object creation process by placing it in a dedicated method, promoting loose coupling between the object creator and the objects themselves.
  * 
  */
public class Runner {
    public static void main(String[] args) {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Client twoWheelerClient = new Client(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        Client fourWheelerClient = new Client(fourWheelerFactory);
        Vehicle fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();
    }
}


abstract class Vehicle {
    public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("This is a Two wheeler object");
    }
}

class FourWheeler extends Vehicle {
    public void printVehicle() {
        System.out.println("This is a Four wheeler object");
    }
}

interface VehicleFactory {
    Vehicle createVehicle(); 
}

class TwoWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

class FourWheelerFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}

class Client {
    private Vehicle pVehicle;

    public Client(VehicleFactory factory) {
        pVehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}

