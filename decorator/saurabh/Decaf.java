package decorator.saurabh;

public class Decaf implements Coffee{
    @Override
    public int getCost() {
        return 10;
    }
    @Override
    public void getDescription() {
        System.out.println("Decaf Coffee");
    }
    
}
