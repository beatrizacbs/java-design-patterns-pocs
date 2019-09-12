package vc.com.justa.adapter.adapters;

import vc.com.justa.adapter.NewClass;
import vc.com.justa.adapter.OldClass;

public class OldToNewAdapter {

    private final OldClass oldClass;

    public OldToNewAdapter(String value){
        System.out.println("Creates Adapter instance");
        oldClass = new OldClass(value);
    }

    public NewClass oldToNew(){
        System.out.println("Turns old into new. You can do whatever here.");
        return new NewClass(oldClass.getOldSomething());
    }
}
