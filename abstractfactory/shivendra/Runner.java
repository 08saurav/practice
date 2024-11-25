package abstractfactory.shivendra;

/*                                           Abstract Factory Design Pattern
 * The Abstract Factory Design Pattern is a creational design pattern used in software development to create
 * families of related or dependent objects without specifying their concrete classes.
 * It provides an interface for creating families of related objects, where the actual implementation of the objects
 * is determined by a concrete factory subclass.
 * 
 * Factory Interface: Defines a set of methods for creating abstract product types.
 * Concrete Factories: Implement the factory interface to create specific products.
 * Abstract Products: Define interfaces or abstract classes for product types.
 * Concrete Products: Implement the abstract product interfaces or classes.
 */

/*
 *                                                How It Works
   1. The client code interacts only with the interfaces defined by the abstract factory and abstract products.
   2. Concrete factories produce concrete products that adhere to the abstract product interfaces.
   3. This allows the client to use different families of products without altering its code,
   thus adhering to the Open/Closed Principle.
*/

public class Runner {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        Application app = new Application(new MacOSFactory());
        app.render();
    }
}

/*
 * --------------------------------------------------- Cross-platform GUI
 * Framework ------------------------------------
 */

interface Button {
    void render();
}

interface CheckBox {
    void check();
}

class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class MacOSButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class WindowsCheckBox implements CheckBox {
    @Override
    public void check() {
        System.out.println("Rendering Windows Button");
    }
}

class MacOSCheckBox implements CheckBox {
    @Override
    public void check() {
        System.out.println("Rendering Windows Button");
    }
}

interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}

class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();

    }
}

class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();

    }
}

class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void render() {
        button.render();
        checkBox.check();
    }
}