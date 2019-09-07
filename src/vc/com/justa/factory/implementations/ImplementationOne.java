package vc.com.justa.factory.implementations;

import vc.com.justa.factory.classes.BaseClass;
import vc.com.justa.factory.interfaces.BaseInterface;

public class ImplementationOne implements BaseInterface {

    private BaseClass baseClass;

    public ImplementationOne(String something){
        this.baseClass = new BaseClass(something);
    }

    @Override
    public BaseClass getBaseClass() {
        return this.baseClass;
    }
}
