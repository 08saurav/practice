package facade.shivendra;

/*                         ------------------  Facade Design Pattern -------------------
 * Suppose we have a very complex system because of multiple classes and multiple functionalities but for external client
 * we want to use only few. So every user who want to use that system may have to read a lot of code and figure out
 * their usecase,it will take lot of time will slow down the development process. To help with this in facade design pattern
 * we will be exposing only functionalities that are being used by external systems to help save their time.
 * for e.g. In webservers we expose only neccessary functionalities to end user not all, other example could we have a large
 * module consisting of more than 100 classes but other modules use only 10 of them rest are being used internally. Then
 * we can expose the neccessary functionalities so that we can hide complexity from developer.
 */

 /*                       ----------------- With What does it help --------------------
  * It decouples client code from complex system i.e change in subsystem does not affect client.
  * The pattern encapsulates the subsystem’s complexity and exposes only what’s necessary.
  */


/* 
 *                        ------------------- Disadvantages -------------------------
 * A poorly designed facade might become too bloated, defeating its purpose.
 * If subsystems change frequently, maintaining the facade can add overhead.
 */

public class Runner {
    public static void main(String[] args) {
        LoggerFacade lf = LoggerFactory.getLogger();
        lf.info("This is INFO");
        lf.error("This is ERROR");
        lf.debug("This is DEBUG");
    }
}


// example logger facade


interface LoggerFacade {
    void info(String message);
    void error(String message);
    void debug(String message);
}

class A {
    public void doSomething() {
        System.out.println("Doing Something - A");
    }
}

class B {
    public void doSomething() {
        System.out.println("Doing Something - B");
    }
}

class C {
    public void doSomething() {
        System.out.println("Doing Something - C");
    }
}

class Logger implements LoggerFacade {
    public void info(String message) {
        new C().doSomething();
        new A().doSomething();
        new B().doSomething();
        System.out.println("[INFO]:" + message);
    }
    public void error(String message) {
        new A().doSomething();
        new C().doSomething();
        new B().doSomething();
        System.out.println("[ERROR]:" + message);
    }
    public void debug(String message) {
        new B().doSomething();
        new A().doSomething();
        new C().doSomething();
        System.out.println("[DEBUG]:" + message);
    }
}

class LoggerFactory {
    public static LoggerFacade getLogger() {
        return new Logger();
    }
}
