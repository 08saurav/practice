package decorator.saurabh;

public class Milk implements AddON{
    Coffee c;
    public Milk(Coffee c){
        this.c = c;
    }
    @Override
    public int getCost() {
        return c.getCost()+3;
    }
    @Override
    public void getDescription() {
        c.getDescription();
        System.out.println(", adding 100ml of more milk");
    }
    
}
