package factory.saurabh;
import  factory.saurabh.Component.button.*;
import  factory.saurabh.Component.dropdown.*;
import  factory.saurabh.Component.menu.*;
// import factory.saurabh.Component.*;
// import factory.saurabh.Android;

public class Runner {
    public static void main(String[] args) {
        Platform p = new Android();
        UIComponentFactory ui =  p.createUIComponentFactory(); //

        Button b1 = ui.createButton();
        Dropdown d1 = ui.createDropdown();
        Menu m1 = ui.createMenu();        

        Platform p1 = new Platform("Android");
        
        // Button b = p.createButton("Android");
    }
}
