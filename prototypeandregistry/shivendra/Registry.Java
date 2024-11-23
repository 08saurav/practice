package prototypeandregistry.shivendra;

import java.util.HashMap;


public class Registry {
    public static void main(String [] args) {
        System.out.println(" ------------------   Prototype And Registry ------------------");
        PrototypeRegistry registry = new PrototypeRegistry();

        registry.addPrototype("zombie", new Zombie());
        registry.addPrototype("warrior", new Warrior());
        registry.addPrototype("animal", new Animal());

        Zombie zombieClone = (Zombie) registry.getPrototype("zombie");
        Warrior warriorClone = (Warrior) registry.getPrototype("warrior");
        Animal animalClone = (Animal) registry.getPrototype("animal");

        System.out.println("Got Zombie Clone With Health : " + zombieClone.health + " Intelligence : " + zombieClone.intelligence);
        System.out.println("Got Warrior Clone With Health : " + warriorClone.health + " Intelligence : " + warriorClone.intelligence);
        System.out.println("Got Animal Clone With Health : " + animalClone.health + " Intelligence : " + animalClone.intelligence);
    }
}

/* Registry Design Pattern overview */

/*
 * The Registry Design Pattern is a pattern used to manage and store a collection of objects in a central location (i.e., a registry or container)
 * , usually identified by a key. It provides a way to retrieve an object from the registry by its key
 * , and optionally, create new objects from the existing ones (often by cloning).
 * 
 * 
 * The pattern helps avoid direct coupling between the classes that need the objects and the classes that provide the objects
 *,making it easier to manage object creation and retrieval dynamically.
 * 
 * Key Concepts: 
 * 
 * Key Concepts:
 * Registry: A central repository where prototype objects are stored.
 * Key: A unique identifier to retrieve a specific prototype object from the registry.
 * Client: The entity that requests an object from the registry and optionally clones it.
 */


 /*
  * Example of Prototype with Registry
  */


abstract class Enemy {
    protected int health;
    protected int damage;
    protected int intelligence;
    public abstract Enemy clone();
}


class Zombie extends Enemy {
    public Zombie() {
        this.health = 100;
        this.damage = 0;
        this.intelligence = 5;
    }

    public Enemy clone() {
        return new Zombie();
    }
}

class Warrior extends Enemy {
    public Warrior() {
        this.health = 100;
        this.damage = 0;
        this.intelligence = 80;
    }

    public Enemy clone() {
        return new Warrior();
    }
}

class Animal extends Enemy {
    public Animal() {
        this.health = 100;
        this.damage = 0;
        this.intelligence = 40;
    }

    public Enemy clone() {
        return new Animal();
    }
}


class PrototypeRegistry {
    private HashMap<String, Enemy>registry = new HashMap<String, Enemy>();

    public void addPrototype(String key, Enemy prototype) {
        registry.put(key, prototype);
    }

    public Enemy getPrototype(String key) {
        Enemy prototype = registry.get(key);
        if (key == null) {
            return null;
        } else {
            return prototype.clone();
        }
    }
}

/*
 * Other Examples of Registry Design Patterns.
 * Maintaining instances of Slack Client, DB Connection Handler, Redis Connection, Google Client, Azure Client, logger client in alfred etc. (Registry + Singleton)
 * Maitaining Registry of Env's (Configs)
 */

