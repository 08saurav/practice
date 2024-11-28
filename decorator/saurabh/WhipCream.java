package decorator.saurabh;

public class WhipCream implements AddON{
    Coffee c;
    public WhipCream(Coffee c){
        this.c = c;
    }
    @Override
    public int getCost() {
        return c.getCost()+5;
    }
    @Override
    public void getDescription() {
        c.getDescription();
        System.out.println(", adding 50ml of whipped cream");
    }
    
}
