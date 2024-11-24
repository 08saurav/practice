package factory.saurabh;

public class UIFactory {
    public static UIComponentFactory createUIComponentFactoryPllatform(String pl){
        if(pl.equalsIgnoreCase("android")){
            return new AndroidUIComponentFactory();
        } else if(pl.equalsIgnoreCase("ios")){
            return new IOSUIComponentFactory();
        }
        return null;
    }
}
