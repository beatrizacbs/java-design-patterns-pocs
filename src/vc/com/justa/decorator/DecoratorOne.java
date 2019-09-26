package vc.com.justa.decorator;

public class DecoratorOne extends BaseDecorator {

    public DecoratorOne(BaseInterface baseInterface) {
        super(baseInterface);
    }

    @Override
    public void contract() {
        System.out.println("Applying DecoratorOne Settings");
    }
}
