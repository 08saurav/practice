package factory.saurabh;

import factory.saurabh.Component.button.*;
import factory.saurabh.Component.dropdown.*;
import factory.saurabh.Component.menu.*;

public interface UIComponentFactory {
    public Button createButton();
    public Dropdown createDropdown();
    public Menu createMenu();
} 