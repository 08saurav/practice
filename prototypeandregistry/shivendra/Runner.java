package prototypeandregistry.shivendra;


/*
 * It is used to make Clone or Copy from existing Object.
 */


/*
 * Why can't we clone on demand using fields from variables
 * e.g.Student s = new Student()
 * s.name = name
 * s.age = age
 * s.roll = roll
 *
 * Issue is some fields might be private may not be accessible to outside world.
 * Computing some of fields from existing might be difficult.
 * Cloning should be responsibility of class itself whose clone have to be made.
 * Since owner class is making clone it is aware about its private members as well.
 * Can be configurable as well
 */

 /*
  * to make logic consistent we will be having prototype and that class has to implement clone function exposed in cloning.
  * 
  */
public class Runner {
    public static void main(String[] args) {
        Student s = new Student("a", "b", "c");
        Student clone = (Student) s.clone();
        System.out.println(clone.print());
    }

}


interface Prototype {
    Prototype clone();
}

class Student implements Prototype {
    private String name;
    private String age;
    private String rollNumber;

    Student() {

    }

    Student(String name, String age, String rollNumber) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    @Override
    public Prototype clone() {
        return new Student(this.name, this.age, this.rollNumber);
    }

    public String print() {
        return "name is " + this.name + " age is " + this.age;
    }
}


/* Practical Examples
 * Cloning Payment Gateway Configurations for merchants
 * Cloning Offers
 * Cloning Notification Templates that we used.
 */


 /*
  * 
The Prototype Design Pattern is a creational pattern that focuses on creating new objects by copying (or cloning) an existing object,
 rather than creating new instances from scratch. It is particularly useful when:

Object Creation is Expensive or Complex:

If creating a new instance of an object involves significant resources, time, or complexity 
(e.g., initializing with expensive resources like database connections or complex state)
, you can use the Prototype pattern to clone an existing object instead.
You Need to Create Many Similar Objects:

When you need to create many similar objects with slight variations,
 the Prototype pattern allows you to create a prototype object with default values and then clone it
 , making small modifications as needed.
Avoiding Tight Coupling to Specific Classes:

If you want to decouple client code from the specific class of the object being created
, the Prototype pattern can be helpful. By cloning objects instead of constructing them through new instances
, you abstract away the exact class being used.
You Need to Create Objects Dynamically Based on Runtime Conditions:

In cases where the type of the object needs to be determined dynamically at runtime
, the Prototype pattern can allow you to clone objects based on a certain prototype
, making it flexible for scenarios where the types of objects are not known in advance.
Ideal Use Cases for the Prototype Design Pattern:
Object Configuration:

When you need to create several objects that share a common configuration but need slight differences
, you can define a "prototype" object that contains the shared configuration.
 You then clone that prototype and make necessary changes.
Example:

In a game development context, you might have a character prototype (say a Warrior object) with common attributes (health, damage, etc.). 
Different variations of that character (e.g., Warrior1, Warrior2, etc.) can be created by cloning the prototype and adjusting only the differences.
Prototypes for Document Editing/Design Systems:

In design systems (such as CAD tools or graphic editors)
, you may want to create multiple similar objects (e.g., shapes or components) that can be customized later. 
Instead of manually creating each object from scratch, cloning a prototype saves time.
Example:

In a vector graphics editor (e.g., Adobe Illustrator), you can create a generic Circle prototype,
 and then clone it for various uses
, making only slight modifications like position, size, or color.
Performance Optimization:

When creating new objects is resource-intensive or time-consuming,
 the Prototype pattern allows you to minimize overhead by cloning an existing object.
  This is especially useful in applications where objects are created frequently.
Example:

In simulations or games where creating new game objects like cars,
 spaceships, or weapons is computationally expensive, you can have a few prototype objects and clone them as needed.
  For instance, instead of creating each car object from scratch
  , you clone a Car prototype and modify its attributes such as speed, model, or color.
Object Cloning for Caching:

The Prototype pattern is also useful in caching scenarios where you might want to clone a cached object and modify some of its properties,
 especially in environments where objects have expensive initialization costs.
Example:

In a web application, you might store a cached prototype of a report template. 
Rather than constructing the entire report from scratch every time, you clone the template, 
modify it as necessary, and then present it.
Stateful Object Cloning:

When objects need to maintain complex state or have mutable properties,
 cloning a prototype can provide a way to quickly reproduce those objects with similar state without manually setting every attribute.
*/


/* -------------------------------------------Example  Code ----------------------------------------------*/

// Prototype class
abstract class Enemy {
    protected int health;
    protected int damage;

    public abstract Enemy clone();
}

class Zombie extends Enemy {
    public Zombie() {
        this.health = 100;
        this.damage = 10;
    }

    public Enemy clone() {
        return new Zombie(); // Return a new Zombie with default stats
    }
}

class Alien extends Enemy {
    public Alien() {
        this.health = 150;
        this.damage = 20;
    }

    public Enemy clone() {
        return new Alien(); // Return a new Alien with default stats
    }
}


/*
 * Limitations of the Prototype Pattern

1. Shallow vs Deep Cloning: The pattern requires careful handling of cloning. 
For example, cloning an object with complex references (i.e., objects containing references to other objects) 
might require deep cloning to avoid shared references between the prototype and its clones. 
This can be complex to implement.

2. Performance Concerns: While cloning can be efficient, 
creating deep copies (e.g., cloning objects with references to other objects) might become resource-intensive depending on the complexity of the object graph.

3. Requires a Cloneable Interface: You need to define a cloning mechanism (e.g., clone() method) for each class involved
, which can become tedious if you have a large hierarchy of objects.
 */
