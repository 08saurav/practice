/*
 * There are three types of design pattern 
 * 1. Creational
 *      a.  Singleton
 *      b.  Registry and Protype
 *      c.  Factory
 *      d.  Builder
 * 2. Structural 
 *      a. Adapter
 *      b. Facade
 *      c. Decorator
 *      d. Flyweight
 * 3. Behavioural
 *      a. Observer
 *      b. Strategy
 *      c. Command
 * 
 * Singleton allows you to only one object to create 
 */

// public class SingleTon {
//     public static void main(String[] args) {
//         SingletonExample SingletonExample1 = SingletonExample.getInstance();
//         SingletonExample SingletonExample2 = SingletonExample.getInstance();
//         SingletonExample SingletonExample3 = SingletonExample.getInstance();
//         SingletonExample SingletonExample4 = SingletonExample.getInstance();
//         SingletonExample SingletonExample5 = SingletonExample.getInstance();
//         // SingletonExample SingletonExample6 = new SingletonExample();
//         // Verifies that both instances are the same
//         System.out.println(SingletonExample1 == SingletonExample2); // This will print true
//     }
// }

public class SingleTon {
    public static void main(String[] args) {
        // Using multiple threads to verify thread safety
        Runnable task = () -> {
            SingletonExample singletonInstance = SingletonExample.getInstance();
            System.out.println(Thread.currentThread().getName() + " got instance: " + singletonInstance);
        };

        // Create and start multiple threads
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");
        Thread thread4 = new Thread(task, "Thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

// Singleton Pattern 
// This is not thread safe
// class SingletonExample {

//     private SingletonExample (){
//         // Constructor should be private to restrict instantiation from other classes.
//     }
//     private static SingletonExample instance = null; // Because Non-static member can't access within static
//     public static SingletonExample getInstance(){
//         if(instance==null) {
//             instance = new SingletonExample();
//         }
//         return instance;
//         // return new SingletonExample();
//     }
// }

// Thread Safe

// class SingletonExample {

//     private SingletonExample (){
//         // Constructor should be private to restrict instantiation from other classes.
//     }
//     private static SingletonExample instance = new SingletonExample(); // This will increase application load time
//     public static SingletonExample getInstance(){
//         return instance;
//     }
// }
// Application load time will increase
// Cannot give the varible Config in the constructor

// class SingletonExample {

//     private SingletonExample (){
//         // Constructor should be private to restrict instantiation from other classes.
//     }
//     private static  SingletonExample instance = null; // but still slow
//     public static synchronized SingletonExample getInstance(){
//         if(instance==null) {
//             instance = new SingletonExample();
//         }
//         return instance;
//     }
// }

/*
 * This appraoch will cause congestion of threads,
 * even though instance is created one thread will be able to access this object at a time.
 */

// Best Solution
class SingletonExample {
    // Private constructor prevents instantiation from other classes
    private SingletonExample() {
    }

    // Volatile ensures visibility of changes to variables across threads
    private static volatile SingletonExample instance = null;

    // Thread-safe and lazy initialization using double-checked locking
    public static SingletonExample getInstance() {
        if (instance == null) { // First check without synchronization
            synchronized (SingletonExample.class) {
                if (instance == null) { // Second check inside synchronized block
                    instance = new SingletonExample();
                    System.out.println("Instance created.");
                }
            }
        }
        System.out.println("Instance found.");
        return instance;
    }
}

