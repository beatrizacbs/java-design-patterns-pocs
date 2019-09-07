package vc.com.justa.adapter.adapters;

import vc.com.justa.adapter.interfaces.BaseInterface;
import vc.com.justa.adapter.models.ObjectTwoModel;

public class ObjectTwoAdapter implements BaseInterface {

    private ObjectTwoModel objectTwoModel;

    public ObjectTwoAdapter(ObjectTwoModel objectTwoModel){
        this.objectTwoModel = objectTwoModel;
    }

    @Override
    public void doSomething() {
        this.objectTwoModel.doSomething();
    }
}
