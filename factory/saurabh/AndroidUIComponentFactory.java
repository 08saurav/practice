package factory.saurabh;

import factory.saurabh.Component.button.*;
import factory.saurabh.Component.dropdown.*;
import factory.saurabh.Component.menu.*;

public class AndroidUIComponentFactory implements UIComponentFactory {
    
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
