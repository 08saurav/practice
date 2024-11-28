package decorator.saurabh;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = new Decaf();
        System.out.println("Cost: " + coffee.getCost());
        coffee.getDescription();

        coffee = new Milk(coffee);
        System.out.println("Cost: " + coffee.getCost());
        coffee.getDescription();

        coffee = new WhipCream(coffee);
        System.out.println("Cost: " + coffee.getCost());
        coffee.getDescription();
    }
    
}
