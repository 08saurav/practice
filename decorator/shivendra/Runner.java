package decorator.shivendra;


/*                           ------------------------- Decorator Design Pattern ---------------------------
 * If we have decorators to be added above base class and they can be added again again then if use classes for every
 * combination of decorators and base class then there would be base class explosion. How to control that ?
 * What if we have dynamic way to combine base classes and decorators, how will we do it ?
 * if we have common interface for decorator and base class i.e. then we can combine base classes and decorators.
 * thats the main idea of decorator.
 */

public class Runner {
    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator(new CaramelDecorator(new SugarDecorator(new Cappuccino())));
        System.out.println(coffee.getCost());
        System.out.println(coffee.getDescription());

    }
}

/* Lets take example of coffe if we are having 3 types of coffies. Espresso, Latte, Cappuccino.
 * And multiple decorators like milk, sugar and caramel.
 * how will we implement for this. so after adding decorators we must return object that inherits base class or interface 
 * that is implemented by base class to avoid explosion of classes. Lets look at implementation
 */

 interface Coffee {
    String getDescription();
    int getCost();
 }


//  Basic implements without decorators
 class Latte implements Coffee {
    public String getDescription() {
        return "Latte Coffee with 10 gm sugar and 100ml milk.";
    }
    public int getCost() {
        return 10;
    }
 }

 class Espresso implements Coffee {
    public String getDescription() {
        return "Espresso Coffee with 10 gm sugar and 100ml milk.";
    }
    public int getCost() {
        return 12;
    }
 }

 class Cappuccino implements Coffee {
    public String getDescription() {
        return "Cappuccino Coffee with 10 gm sugar and 100ml milk.";
    }
    public int getCost() {
        return 15;
    }
 }

 abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public int getCost() {
        return coffee.getCost();
    }
 }

 class MilkDecorator extends  CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Adding 100ml of more milk";
    }

    @Override
    public int getCost() {
        return super.getCost() + 5;
    }
 }

 class SugarDecorator extends  CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Adding 10g of more sugar";
    }

    @Override
    public int getCost() {
        return super.getCost() + 2;
    }
 }

 class CaramelDecorator extends  CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Adding 10g of more caramel";
    }

    @Override
    public int getCost() {
        return super.getCost() + 10;
    }
 }

// Practical Usecases
/**
 * surcharges and offers need to be dynamically applied to an order. 
 * The pattern allows you to dynamically modify the behavior of the order calculation (e.g., total cost)
 *  by wrapping the base order logic with additional functionalities such as payment method surcharges and offer discounts.
 */