package Singleton.shivendra;

public final class Singleton {
    private static volatile Singleton instance;
    private String connString;

    private Singleton(String value) {
        this.connString = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }

    public static Singleton getInstanceThreadSafe(String value) {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }

        }
        return instance;
    }

    public String getValue() {
        if(instance == null) {
            return "";
        }
        return instance.connString;
    }
}

