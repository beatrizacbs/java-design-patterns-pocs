package vc.com.justa.prototype;

/**
 * Concrete class representing object one
 */
public class PrototypeOne extends BasePrototype {

    private String prototypeOne;

    public PrototypeOne(PrototypeOne prototypeOne) {
        super(prototypeOne);
        this.prototypeOne = prototypeOne.prototypeOne;
    }

    /**
     * Clone() method implementation
     * @return the instance created
     */
    @Override
    BasePrototype klone() {
        return new PrototypeOne(this);
    }
}
