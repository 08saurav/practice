package Java.shivendra;

/**
 * 
Advantages of method overloading
    Readability and Maintainability: Overloading allows methods to have the same name and different parameter lists,
     which increases readability and comprehensibility of the code. 
     It helps developers to name the different functions in a good way so that other developers 
     can easily understand the code and maintain it.

    Code Reusability: To avoid using too many methods with different names even when their function is similar, 
    method overloading makes it possible to reuse method names but have different types or numbers of parameters. 
    It causes the code to be reusable and, therefore, reduces code duplication.

    Flexibility: Method overloading gives the developer an advantage in creating methods which can be called 
    with any number of different parameters types or numbers. It offers such flexibility to make APIs that can be expanded
     to multiple utilities.

    Polymorphism: Method overloading is a key to the realization of polymorphism in the Java, 
    which permits objects of the same type to react differently to method calls depending on the method's arguments.
     This behavior somewhat polymorphic, hence leads to modularity and extensibility of code.

    Simplifies API Design: In the case of API design, the method overload is simplifying the interface as it 
    serves multiple ways in which to interact with the same 
    functionality. The API users can select the most convenient method signature according to their needs
     and then create a more 
    thoughtful and user-centered interface as a result.
    Advertisement


    Enhances Code Readability: Overloading methods creates an opportunity of having multifaceted functions encapsulated within a class.
    Developers not only pick the same method name for similar operations, but also the purpose of each method becomes clearer, 
    as well as their intended use cases.

Disadvantages of method overloading
Ambiguity: Overloading may result in ambiguity if two of more overloaded methods have the same types of parameters. 
In such instances, the compiler cannot tell which method has to be invoked based on argument
 alone therefore compilation error can occur.

Complexity: Deepening the use of method overloading may make code complex, 
especially if there are many overloaded methods with similar names but different patterns of parameters.
Such complexity raises the bar for apprehension of code and its maintenance, particularly for developers
 who are knowledgeable about the codebase.

Hidden Behavior: Similar APIs might have different outcomes and behaviours, 
which may confuse the developers in such kind of situation. If such a utilization of class methods is not properly 
documented or understood, then it may lead to unexpected outcomes or bugs in the code.

Performance Overhead: Nonetheless, the contribution of performance impact of method overloading is, 
in fact, negligible, however, the presence of the excessive use of overloaded methods with complex parameter lists 
could lead to a slight performance overhead mainly due to method resolution at runtime.

Overuse: Some developers may bypass this rule completely and use method overloading too much to avoid coming up
 with different method names for similar features. In comparison, excessive calling of overloading methods 
 carries the risk of code bloat and decreased code clarity, hence making it harder to underpin each method purpose.


Maintenance Challenges: Developers who are modifying or extending code which contains method overloading method should 
be even more careful to ensure that the changes they make will not affect the behavior of other overloaded methods 
unintentionally. This creates greater maintenance difficulty, which is particularly true in the case of extensive codebases.
 */

public class Polymorphism {
    // method overloading (compile time polymorphism)
    // If this is hidden then type ambiguity will occur in 7 and 8
    int add(int a, int b) {
        System.out.println("1");
        return a + b;
    }

    double add(double a, double b) {
        System.out.println("2");
        return a + b;
    }

    double add(double a, int b) {
        System.out.println("3");
        return a + b;
    }

    double add(int a, double b) {
        System.out.println("4");
        return a + b;
    }

    double add(double a, double b, double c) {
        System.out.println("5");
        return a + b + c;
    }

    long add(long a, int b) {
        System.out.println("7");
        return a + b;
    }

    long add(int a, long b) {
        System.out.println("8");
        return a + b;
    }
    public static void main(String[] args) {
        Polymorphism p = new Polymorphism();

        /*
         * Java/shivendra/Polymorphism.java:41: error: reference to add is ambiguous
           p.add(3,4);^
            both method add(long,int) in Polymorphism and method add(int,long) in Polymorphism match
            1 error
         */
        p.add(3,4);
        p.add(2.9,5.0);
        p.add(4.0,5);
        p.add(4, 5.0);
        p.add(1,2,3);

        Polymorphism c = new C();
        c.add(3,4);
    }
}

class C extends Polymorphism {
    // Dynamic Method Dispatch or Runtime Polymorphism
    @Override
    long add(long a, int b) {
        System.out.println("6");
        return a + b;
    }
}

// Overriding Covariant Return type.

class AA {
    AA get() {
        return this;
    }
}

// Covariant return type helps in preventing the run-time ClassCastExceptions on returns.
class BB extends AA {
    int x;
    // Initializer block
    {
        /**
         * Instance Initializer block is used to initialize the instance data member. 
         * It run each time when object of the class is created.
         */
        x = 100;
    }
    // as BB is subtype of AA so it is compatible with AA hence compatible.
    @Override
    BB get() {
        return this;
    }
}

/** final Keyword */

/*
 * final variable: Once initialized can't be changed.
 * final method: can't be overriden
 * final class: can't be inherited
 * static blank final variable: A static final variable that is not initialized at the time of declaration is known as static blank final variable.
 *                              It can be initialized only in static block.
 * final parameter: If you declare any parameter as final, you cannot change the value of it.
 * constructor can't be made final
 */

