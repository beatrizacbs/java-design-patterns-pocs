package vc.com.justa.decorator;

public abstract class BaseDecorator implements BaseInterface {

    private BaseInterface baseInterface;

    public BaseDecorator(BaseInterface baseInterface) {
        this.baseInterface = baseInterface;
    }

    @Override
    public void contract() {
        System.out.println("Base Decorator");
        baseInterface.contract();
    }
}
