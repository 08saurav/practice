package decorator.saurabh;

public class HouseBlend implements Coffee{
    @Override
    public int getCost() {
        return 15;
    }
    @Override
    public void getDescription() {
        System.out.println("House Blend Coffee");
    }
    
}
