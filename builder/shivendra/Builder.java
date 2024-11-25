package builder.shivendra;

public class Builder {
    public static void main(String[] args) {
        System.out.println("Hello world");
        // Create a specific builder (ToyotaCarBuilder)
        Car car = new ToyotaCarBuilder()
                .buildColor()
                .buildEngine()
                .buildWheels()
                .build();

        // Display the constructed car
        System.out.println(car);

        /*
         * If we have some static set of Objects with some variable parameters we can define various constructs for builder in
         * Director and use that but if the number of parameters grows we will again face same issue.
         * then we can take config object which will be using builder and use it construct builder and then build the actual object.
         */

        // Constructing Car with Director
        System.err.println(new Director(new ToyotaCarBuilder()).build());
    }
}

/* What is Builder Design Pattern */

/*
 * The Builder Pattern is a creational design pattern that is used to construct
 * complex objects by separating the construction process from the actual object
 * representation.
 * It allows for the construction of different types and representations of an
 * object using the same construction process, ensuring that the object's
 * construction is step-by-step and flexible.
 * The Builder Pattern is particularly useful when an object needs to be created
 * with many possible configuration options,
 * or when an object has many parts that need to be set in a particular sequence
 * or combination.
 */

/*
 * Key Components of the Builder Pattern
 * Product:
 * This is the complex object that needs to be constructed. The Product defines
 * the final object that the Builder will create.
 *
 * Builder:
 * The Builder is an abstract interface that defines methods for creating the
 * different parts of the Product.
 * It provides step-by-step instructions for constructing the object.
 *
 * ConcreteBuilder:
 * The ConcreteBuilder is a specific implementation of the Builder.
 * It defines the parts of the Product and assembles them according to the
 * step-by-step process.
 * We can add validations as well inside buildIndependent functions
 *
 * Client:
 * The Client is responsible for using the Builder to construct
 * the Product. It doesn't need to know the details of the construction process.
 *
 * Director:
 * We might need director if we want to make some restrictions on sequence.
 * Or we add some validations etc.
 */


/*
Use Cases for Builder Pattern:
Complex Object Construction: When an object has many fields, especially optional ones, and the construction involves several steps.
Fluent APIs: Builders are often used to create fluent APIs that allow chaining method calls.
Immutable Objects: When constructing immutable objects, builders can be helpful in ensuring all required fields are set before the object is created.
Variations of an Object: When you need to create different representations of the same object with different configurations.
 */
// Product Class
class Car {
    private String engine;
    private int wheels;
    private String color;

    public String getEngine() {
        return this.engine;
    }

    public int getWheels() {
        return this.wheels;
    }

    public String getColor() {
        return this.color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", wheels=" + wheels + ", color=" + color + "]";
    }
}

// Builder Interface
interface CarBuilder {
    CarBuilder buildEngine();

    CarBuilder buildWheels();

    CarBuilder buildColor();

    Car build();
}

class Director {
    CarBuilder builder;

    public Director(CarBuilder builder) {
        this.builder = builder;
    }

    // this might be needed if we want to force sequence etc...

    public Car build() {
        return builder.buildColor()
                      .buildEngine()
                      .buildWheels()
                      .build();
    }
}

// Concrete Builder
class ToyotaCarBuilder implements CarBuilder {
    private Car car;

    public ToyotaCarBuilder() {
        this.car = new Car();
    }

    @Override
    public CarBuilder buildEngine() {
        car.setEngine("Toyota Engine");
        return this;
    }

    @Override
    public CarBuilder buildWheels() {
        car.setWheels(4); // A Toyota car has 4 wheels
        return this;
    }

    @Override
    public CarBuilder buildColor() {
        car.setColor("Red");
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}


/**
 * In Real life we would be using Builder for Constructing Orders, Offers, Gateway Creation etc... 
 * if we were using Object Oriented language.
 */