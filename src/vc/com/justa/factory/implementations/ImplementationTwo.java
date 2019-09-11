package vc.com.justa.factory.implementations;

import vc.com.justa.factory.classes.BaseClass;

public class ImplementationTwo extends BaseClass {

    private String someOtherThingHereToo;

    public ImplementationTwo(int something, String someOtherThingHereToo){
        super(something);
        this.someOtherThingHereToo = someOtherThingHereToo;
        System.out.println("Builds object with ImplementationTwo especifications: " + this.someOtherThingHereToo);
    }

    @Override
    public void doSomething() {
        System.out.println("Enters the method doSomething() of ImplementationTwo: " + this.someOtherThingHereToo);
    }

}
