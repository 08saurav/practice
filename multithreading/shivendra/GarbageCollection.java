package multithreading.shivendra;

/*
 * gc() and finalize() in Java
Java provides mechanisms to manage memory automatically, including garbage collection. Two important concepts related to garbage collection are gc() and finalize().

1. gc() Method
The gc() method is part of the java.lang.Runtime and java.lang.System classes. It is a request to the JVM to perform garbage collection. However, calling gc() does not guarantee that garbage collection will happen immediately or at all.

Key Points
It is a hint or request to the JVM, not a command.
The JVM decides whether and when to perform garbage collection.
Used for resource management and cleanup in combination with other code.
 */

/*
 * finalize() Method
The finalize() method is a callback provided by the java.lang.Object class. It is called by the garbage collector before reclaiming the memory of an object.

Key Points
Used to perform cleanup operations (e.g., closing files, releasing resources) before the object is destroyed.
Only called once per object, and only if the garbage collector decides to reclaim the object's memory.
Deprecated since Java 9 and removed in Java 18, as it is considered unreliable and prone to issues.
 */

public class GarbageCollection {
    public static void main(String[] args) {
        Object o = new Object();

        System.gc();
    }

    @Override
    public void finalize() {
        System.out.println("Performing finalize before gc...");
    }
}
