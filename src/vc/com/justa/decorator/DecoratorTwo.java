package vc.com.justa.decorator;

public class DecoratorTwo extends BaseDecorator {

    public DecoratorTwo(BaseInterface baseInterface) {
        super(baseInterface);
    }

    @Override
    public void contract() {
        System.out.println("Applying DecoratorTwo Settings");
    }

}
