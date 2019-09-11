package vc.com.justa.factory.factory;

import vc.com.justa.factory.classes.BaseClass;
import vc.com.justa.factory.implementations.ImplementationOne;
import vc.com.justa.factory.implementations.ImplementationTwo;

public class ClassFactory {

    public static BaseClass createClass(int something, String somethingElse){
        switch (something){
            case 1:
                return new ImplementationOne(something, somethingElse);
            case 2:
                return new ImplementationTwo(something, somethingElse);
            default:
                return null;
        }
    }

}
