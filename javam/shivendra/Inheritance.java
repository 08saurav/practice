package javam.shivendra;

/*
 * In case of inheritance child class inherits properties from parent class i.e. IS-A relationship
 * Types:
 * Single, Multilevel, Multiple (Not supported), hierarchial
 */

 /*
  * Try to use composition instead of inheritance as it is more manageable and scalable.
  */


class A {
    int num;
    String str;

    void method(String s) {
        System.out.println("Hello : " + s);
    }
}

class B extends A {
    // Single Inheritance
    void methodN(String s) {
        System.out.println(super.num + ", " + super.str);
        super.method(s);
    }
}

class C extends B {
    // Multilevel Inheritance
    void methodC() {
        super.methodN("C");
        super.method(super.str);
    }

    // runtime polymorphism via method overriding
    @Override
    void methodN(String s) {
    }
}

class D extends B {
    // hierarchical Inheritance
    void methodD() {

    }
}

// Multiple Inheritance is not supported via class while supported via interfaces

interface X {
    void fx();
    void f();
}

interface Y {
    void fy();
    void f();
}

class Z implements X, Y {
    public void fx() {

    }

    public void fy() {

    }

    public void f() {

    }
}

/**
 * Aggregation/Composition : Has A relationship
 */

 class XY {
    A a; // XY is composed of A
 }

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}


