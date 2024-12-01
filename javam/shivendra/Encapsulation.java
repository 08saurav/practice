package java.shivendra;

/* Package : A java package is a group of similar types of classes, interfaces and sub-packages.
 * Types: BuiltIn, user
 * Accessing package members:
 * Import All : import Java.shivendra.*
 * Import Specific Class: import Java.shivendra.Inheritance
 * if you import a package , subpackage won't be imported
 */

 /*                           Access Modifiers
  * Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
  * Default: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. 
             If you do not specify any access level, it will be the default.
  * Protected: The access level of a protected modifier is within the package and outside the package through child class. 
               If you do not make the child class, it cannot be accessed from outside the package.
  * Public: The access level of a public modifier is everywhere. 
           It can be accessed from within the class, outside the class, within the package and outside the package.
  */



  /*                                  Encapsulation                               */
  /*
   * Encapsulation in Java is a process of wrapping code and data together into a single unit,
   * for example, a capsule which is mixed of several medicines.
   *
   * We can create a fully encapsulated class in Java by making all the data members of the class private.
   * Now we can use setter and getter methods to set and get the data in it.

   * e.g. The Java Bean class is the example of a fully encapsulated class.
   */


/*                Read Only Class                    */

class ROnly {
    private int a;
    private String b;

    public ROnly(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return this.a;
    }

    public String getB() {
        return this.b;
    }
}

class RW {
    private int a;
    private String b;

    public RW(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return this.a;
    }

    public String getB() {
        return this.b;
    }

    public void setA(int a) {
        if(a > 0) {
            this.a = a;
        }
    }

    public void setB(String a) {
        if(a != "") {
            this.b = a;
        }
    }
}
public class Encapsulation {
    public static void main(String[] args) {
        
    }
}
