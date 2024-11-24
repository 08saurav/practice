package factory.saurabh;

// import factory.saurabh.Component.button.*;

public class Platform {

    private String p;
    public Platform() {
        
    }

    Platform(String p) {
        this.p = p;
    }
    public void setTheme(){
        System.out.println("Set a theme!");
    }

    public void setRefreshRate(){
        System.out.println("Set refresh rate!");
    }
    // public Button createButton(String button){
    //     if(button.equalsIgnoreCase("android")){
    //         return new AndroidButton();
    //     } else if(button.equalsIgnoreCase("ios")){
    //         return new IOSButton();
    //     } 
    //     return null;
    // }
    public UIComponentFactory createUIComponentFactory(){
        return null;
    }
    public UIComponentFactory componentFactory(){
        // if(p.equalsIgnoreCase("android")){
        //     return new AndroidUIComponentFactory();
        // } else if(p.equalsIgnoreCase("ios")){
        //     return new IOSUIComponentFactory();
        // }
        // return null;
        return UIFactory.createUIComponentFactoryPllatform(this.p);
    }
}
