package factory.saurabh;

public class Android extends Platform{

    @Override
    public UIComponentFactory createUIComponentFactory() {
        return new AndroidUIComponentFactory();
    }
}
