package vc.com.justa.factory.implementations;

import vc.com.justa.factory.classes.BaseClass;

public class ImplementationOne extends BaseClass {

    private String someOtherThingHere;

    public ImplementationOne(int something, String someOtherThingHere){
        super(something);
        this.someOtherThingHere = someOtherThingHere;
        System.out.println("Builds object with ImplementationOne especifications: " + this.someOtherThingHere);
    }

    @Override
    public void doSomething() {
        System.out.println("Enters the method doSomething() of ImplementationOne: " + this.someOtherThingHere);
    }

}
