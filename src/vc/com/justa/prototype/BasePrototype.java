package vc.com.justa.prototype;

/**
 * Base class that maintains the contract
 */
public abstract class BasePrototype {

    private String something;

    public BasePrototype(BasePrototype basePrototype) {
        this.something = basePrototype.something;
    }

    /**
     * Abstract methot to be implemented
     * @return
     */
    abstract BasePrototype klone();
}
