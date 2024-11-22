package prototypeandregistry.saurabh;

/*
 * create an copy of object and use that object
 * challenges
 * 1. Code is not resuable
 * 2. cleint need to know all details of class
 * 3. what if some variable are private , so copying will be difficult
 * will copy constructor will work?
 *  void doSomething(Student st) {
    // Avoid creating a new Student directly using a copy constructor
    if (st instanceof IntelligentStudent) {
        new IntelligentStudent(st); // Handles the specific subclass
    }
    // Additional checks for other subclasses can follow here (e.g., elseif for other types)
}

    Key Points:
    Hierarchy Structure:

    Student is the base class.
    IntelligentStudent is a subclass that extends Student.
    OCP (Open-Closed Principle):

    Violating OCP here as adding new subtypes requires modifying this method (doSomething), leading to rigid design.
    Drawback of Using Copy Constructor:

    Not Polymorphic: Directly copying using a Student copy constructor does not preserve the subclass type.
    Rigid Design: You need to explicitly check types (instanceof), making the code harder to extend for future subclasses.

    create a protype and store it(Registry)

 */

/* Prototype Design Pattern and Registry
 The Prototype Pattern is a creational design pattern used to create object instances by copying or cloning 
 existing objects rather than creating new instances from scratch. It is useful when the cost of initializing an object is expensive or complex.
 
 Key Concepts
 Prototype:
 
 It is an interface or abstract class defining a clone method for cloning objects.
 Each concrete class implements this method to return a copy of itself.
 Prototype Registry:
 
 A centralized place where prototypes are stored and retrieved.
 It allows clients to obtain pre-configured object instances by name or type.
 Enhances performance and avoids repetitive instantiation logic.
 Steps in Prototype Pattern
 Define a Prototype Interface:
 
 Declare a clone method for cloning objects.
 Create Concrete Prototypes:
 
 Implement the prototype interface with specific classes.
 Use Prototype Registry:
 
 Store prototypes in a registry (e.g., a HashMap) for easy access and reuse.
 Client Code:
 
 Retrieve prototypes from the registry and clone them as needed.
 Code Example
 Prototype Interface
 java
 Copy code
 interface Prototype {
     Prototype clone();
 }
 Concrete Prototype Classes
 java
 Copy code
 class Circle implements Prototype {
     private int radius;
 
     public Circle(int radius) {
         this.radius = radius;
     }
 
     @Override
     public Prototype clone() {
         return new Circle(this.radius);
     }
 
     @Override
     public String toString() {
         return "Circle with radius: " + radius;
     }
 }
 
 class Rectangle implements Prototype {
     private int width, height;
 
     public Rectangle(int width, int height) {
         this.width = width;
         this.height = height;
     }
 
     @Override
     public Prototype clone() {
         return new Rectangle(this.width, this.height);
     }
 
     @Override
     public String toString() {
         return "Rectangle with width: " + width + " and height: " + height;
     }
 }
 Prototype Registry
 java
 Copy code
 import java.util.HashMap;
 import java.util.Map;
 
 class PrototypeRegistry {
     private Map<String, Prototype> registry = new HashMap<>();
 
     public void addPrototype(String key, Prototype prototype) {
         registry.put(key, prototype);
     }
 
     public Prototype getPrototype(String key) {
         Prototype prototype = registry.get(key);
         return (prototype != null) ? prototype.clone() : null;
     }
 }
 Client Code
 java
 Copy code
 public class PrototypeDemo {
     public static void main(String[] args) {
         // Create the registry
         PrototypeRegistry registry = new PrototypeRegistry();
 
         // Add prototypes
         registry.addPrototype("Circle", new Circle(10));
         registry.addPrototype("Rectangle", new Rectangle(20, 30));
 
         // Retrieve and clone prototypes
         Prototype clonedCircle = registry.getPrototype("Circle");
         Prototype clonedRectangle = registry.getPrototype("Rectangle");
 
         // Display cloned objects
         System.out.println(clonedCircle);
         System.out.println(clonedRectangle);
     }
 }
 Advantages
 Performance:
    Cloning existing objects is faster than creating new ones from scratch.
 Customization:
    Pre-configured objects can be quickly duplicated with slight modifications.
 Reduces Code Duplication:
    Avoids repetitive instantiation and setup logic.
 Disadvantages
Deep Cloning Complexity:
    Handling objects with complex nested structures can be tricky.
 Prototype Registry Maintenance:
    Keeping the registry updated with new prototypes requires additional effort.
 When to Use
    Object creation is expensive (e.g., database initialization, complex configurations).
    You need multiple instances of similar objects.
    Avoid subclassing for object creation, especially when objects share common properties.
Interview Notes
 Prototype Design Pattern:
 
    Focus on cloning objects rather than creating them from scratch.
    Useful for scenarios like game object creation, configuration management, or object pools.
    Prototype Registry:
 
    Acts as a central place to store and retrieve prototypes.
    Key for managing and reusing pre-configured objects.
    Core Interface:
 
    Prototype interface with a clone() method.
    Cloning can be shallow (copies fields as-is) or deep (recursively clones all fields).
    Key Differences:
 
    Prototype Pattern: Focuses on cloning.
    Registry: Provides a centralized mechanism to retrieve pre-defined prototypes.
    This should give you a crisp overview for your interview prep!
 */
public interface Prototype<T>{
    public T copy();
} 