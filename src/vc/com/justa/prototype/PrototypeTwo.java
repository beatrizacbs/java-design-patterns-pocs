package vc.com.justa.prototype;

/**
 * Second concrete class to clone
 */
public class PrototypeTwo extends BasePrototype {

    private String prototypeTwo;

    public PrototypeTwo(PrototypeTwo prototypeTwo){
        super(prototypeTwo);
        prototypeTwo.prototypeTwo = prototypeTwo.prototypeTwo;
    }

    /**
     * The Clone() method that clones the object creating a new instance
     * @return the object created
     */
    @Override
    BasePrototype klone() {
        return new PrototypeTwo(this);
    }
}
