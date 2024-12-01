package javam.shivendra;


// It is achieved through abstract classes and interfaces.
// interface as name suggest provides interface without knowing what methods internally does.
// Abstraction is a process of hiding the implementation details and showing only functionality to the user.

/**
 * Achieved through abstract classes and interfaces.
 * Using Abstract Class (0 to 100%)
 * Using Interface (100%)
 * An abstract class must be declared with an abstract keyword.
 * It can have abstract and non-abstract methods.
 * It cannot be instantiated.
 * It can have constructors and static methods also.
 * It can have final methods which will force the subclass not to change the body of the method.
 */

 /**
  * Abstract Class
  */

  abstract class AbstractClass {
    abstract void execute(); // these methods needs to implementted by concrete classes.
    void undo() {
        System.out.println("Undoing an operation");
    }
  }

  abstract class X extends AbstractClass {

  }

  /* Interface */
  /* 100 % abstraction */

  interface A {
    void execute();
    void undo();
  }


  /* Inheritance of interfaces */

  interface B extends A {
    public static void iAmStatic() {
        System.out.println("Static Method in Interface");
    }
    void retry();
  }

  class BB implements B {
    public void execute() {

    }
    public void undo() {
        
    }

    public void retry() {
        
    }
  }


public class Abstraction {
    public static void main(String[] args) {
        B.iAmStatic();
    }
}

/* Nested Interfaces and Classes */

interface AX {
    void f();
    class X {
        private interface InnerAbstraction {
            void fI();
        }
    
        class XY implements InnerAbstraction {
            public void fI() {
                System.out.println("Hello World");
            }
        }

    }
}
