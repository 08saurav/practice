package factory.saurabh;

public class IOS extends Platform {
    @Override
    public UIComponentFactory createUIComponentFactory() {
        return new IOSUIComponentFactory();
    }
}
