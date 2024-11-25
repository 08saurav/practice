package factory.shivendra;

 /*
  * Factory Design Pattern
  * It gives an Interface for creating objects from a superclass
  * When it should be used :
  * It is to be used when type of objects to be created needs to be determined at time of run time or users input.
  * This pattern simplifies the object creation process by placing it in a dedicated method
    , promoting loose coupling between the object creator and the objects themselves.
  * The client does not need to know the details of how the object is created, just that it needs a particular type of object.
  * The factory can decide which class to instantiate based on parameters, configuration, or user input.
  * If the process of creating an object is complicated (e.g., involves multiple steps, dependencies, or configuration),
    you can isolate this complexity in the factory.
  */


/*
 * Key Concepts:
Product: The object that is created by the factory (e.g., a Car, Truck, or Motorcycle).
Factory: A class or method responsible for creating instances of products.
Client: The user or consumer who requests a product from the factory but doesn’t know the exact type of product it is.
 */

/*
 * This Design Pattern Helps us in maintaining Single Responsibiltity Principle 
 * for e.g. if there is change in way of creation of objects there would be only one class to be changed not 
 * all the classes needs to be changed which helps in having maintanable and scalable code.
 */

/* When to not use factory design pattern */
/*
 *
 When Not to Use the Factory Pattern
    The Factory pattern is useful in many scenarios, but it's not always the best choice.
    Here are some situations where it might be better to avoid it:
    Simple Object Creation: If objects are simple and don't require complex creation logic or families of related products, 
    the Factory pattern might be overkill.
    Frequent Changes to Object Creation: If the object creation logic is constantly changing, 
    using a Factory might lead to a lot of churn and increase maintenance cost.
    No Clear Family of Products: If there are no distinct families of related products that require different variations 
    (i.e., when the need for decoupling object creation isn't strong), then a factory might be unnecessary.
 */

public class factory {
    public static void main(String[] args) {
        EnemyFactory e = new EnemyFactory();
        Zombie z = (Zombie) e.createEnemy("zombie", 1, 2, 3, 4);
        System.err.println("p : " + z.power + " , b" + z.biteforce);

        Alien a = (Alien) e.createEnemy("alien", 1, 2, 3, 4);
        System.err.println("p : " + a.power + " , b" + a.visibility);

        Robot r = (Robot) e.createEnemy("robot", 1, 2, 3, 4);
        System.err.println("p : " + r.power + " , b" + r.intelligence);


        // Without Factory if we have to create 2 zombies, aliens and robots
        Zombie z1 = new Zombie();
        z1.power = 1;
        z1.biteforce = 2;
        System.err.println("Zombie -> power: " + z1.power + ", biteforce: " + z1.biteforce);

        // Directly creating Alien
        Alien a1 = new Alien();
        a1.power = 3;
        a1.visibility = 4;
        System.err.println("Alien -> power: " + a1.power + ", visibility: " + a1.visibility);

        // Directly creating Robot
        Robot r1 = new Robot();
        r1.power = 5;
        r1.intelligence = 6;
        System.err.println("Robot -> power: " + r1.power + ", intelligence: " + r1.intelligence);

        Zombie z2 = new Zombie();
        z2.power = 1;
        z2.biteforce = 2;
        System.err.println("Zombie -> power: " + z2.power + ", biteforce: " + z2.biteforce);

        // Directly creating Alien
        Alien a2 = new Alien();
        a2.power = 3;
        a2.visibility = 4;
        System.err.println("Alien -> power: " + a2.power + ", visibility: " + a2.visibility);

        // Directly creating Robot
        Robot r2 = new Robot();
        r2.power = 5;
        r2.intelligence = 6;
        System.err.println("Robot -> power: " + r2.power + ", intelligence: " + r2.intelligence);

        // Suppose now we are changing logic power is changed from p to p*p then there would be large number of changes.
        //  Defying SOLID principles
    }
}

abstract class Enemy {
    abstract void attack();
}

class Zombie extends Enemy {
    int biteforce;
    int power;
    public void attack() {
        System.err.println("Zombie is Attacking with biteforce : " + biteforce + " and power : " + power);
    }
}

class Alien extends Enemy {
    int visibility;
    int power;
    public void attack() {
        System.err.println("Zombie is Attacking with power : " + power + " visibility : " + visibility );
    }
}

class Robot extends Enemy {
    int intelligence;
    int power;
    public void attack() {
        System.err.println("Zombie is Attacking with power : " + power + "and intelligence : " + intelligence);
    }
}

class EnemyFactory {
    public Enemy createEnemy(String type, int power, int biteforce, int visibility, int intelligence) {
        switch (type) {
            case "zombie":
                Zombie z = new Zombie();
                z.power = power;
                z.biteforce = biteforce;
                return z;
            case "alien":
                Alien a = new Alien();
                a.power = power;
                a.visibility = visibility;
                return a;
            case "robot":
                Robot r = new Robot();
                r.power = power;
                r.intelligence = intelligence;
                return r;
            default:
                return null;
        }
    }
}

