package factory.saurabh;

import factory.saurabh.Component.button.*;
import factory.saurabh.Component.dropdown.*;
import factory.saurabh.Component.menu.*;

// Define the UIComponentFactory interface
public class IOSUIComponentFactory implements UIComponentFactory {

    @Override
    public Button createButton() {
        return new IOSButton();
    }   

    @Override
    public Dropdown createDropdown() {
        return new IOSDropdown();
    }   

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}

