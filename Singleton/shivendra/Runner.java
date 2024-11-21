package Singleton.shivendra;

public class Runner {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance("Hello");
        System.out.println(s.getValue());
        Singleton s1 = Singleton.getInstance("7890");
        System.out.println(s1.getValue());
    }
}
