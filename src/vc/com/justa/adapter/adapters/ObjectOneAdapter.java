package vc.com.justa.adapter.adapters;

import vc.com.justa.adapter.interfaces.BaseInterface;
import vc.com.justa.adapter.models.ObjectOneModel;

public class ObjectOneAdapter implements BaseInterface {

    private ObjectOneModel objectOneModel;

    public ObjectOneAdapter(ObjectOneModel objectOneModel){
        this.objectOneModel = objectOneModel;
    }

    @Override
    public void doSomething() {
        this.objectOneModel.doSomething();
    }
}
