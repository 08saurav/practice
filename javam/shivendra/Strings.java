package javam.shivendra;

/*
 * In Java, string is basically an object that represents sequence of char values.
 * An array of characters works same as Java string.
 */

/*
 * CharSequence Interface:
       The CharSequence interface is used to represent the sequence of characters.
       String, StringBuffer and StringBuilder classes implement it.
       It means, we can create strings in Java by using these three classes.

 * CharSequence in Java:
       The Java String is immutable which means it cannot be changed.
       Whenever we change any string, a new instance is created.
       For mutable strings, you can use StringBuffer and StringBuilder classes.
 */

/*
 * Implemented Interfaces: The String class implements several interfaces, including:
      Serializable: Allows string objects to be serialized into byte streams, facilitating their transmission or storage.
      Comparable<String>: Enables lexical comparison between two strings, supporting natural ordering within collections.
      CharSequence: Provides a unified read-only interface for different kinds of char sequences, 
      allowing String objects to be manipulated and accessed generically.
 */

/*
 * StringBuffer
     StringBuffer represents a mutable sequence of characters that ensures thread safety, 
     making it suitable for scenarios involving multiple threads that modify a character sequence. 
     It includes various string manipulation capabilities, including the ability to insert, delete, and append characters.
     This design avoids the necessity of generating new objects with each change, 
     leading to enhanced efficiency in situations requiring regular adjustments to the string content.
 */

public class Strings {
    public static void main(String[] args) {
        char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f' };
        String str = new String(ch);

        String str2 = new String(str);

        if (str.compareTo(str2) == 0) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
        }

        if (str == str2) {
            System.out.println("Raw Strings Matched");
        } else {
            System.out.println("Raw Strings Not Matched");
        }

        String s = "Welcome";
        String s2 = "Welcome";

        // No new strings are created for s2 , JVM tries to find "Welcome" in string
        // constant pool and assigned it to s2

        if (s == s2) {
            System.out.println("Raw Strings Matched");
        } else {
            System.out.println("Raw Strings Not Matched");
        }

        // String Buffer
        /*
         * Thread Safe
         */
        StringBuffer b = new StringBuffer("Hello");
        b.append(" World");
        b.insert(3, "HHJJJ");
        b.delete(5, 6);

        /*
         * String Builder : Not Thread Safe to be used in single threaded environment.
         */
        StringBuilder b1 = new StringBuilder("dkfrs");
        b1.append(" World");
        b1.insert(3, "HHJJJ");
        b1.delete(5, 6);

        /*
         * Interning: We can manually add a string to the Pool or ensure it uses the
         * Pool by calling the intern() method on a string object.
         * If the Pool already contains an equal string, the string from the Pool is
         * returned. Otherwise, the string is added to the Pool.
         */

        String s4 = new String("Hello").intern(); // Ensures use of the string pool
    }
}
