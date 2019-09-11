package vc.com.justa.main;

import vc.com.justa.builder.ObjectOne;
import vc.com.justa.factory.factory.ClassFactory;
import vc.com.justa.singleton.SingletonObject;

public class Main {

    public static void main(String[] args){

        System.out.println("Starts demonstration of the design patterns implementation and functions.\nYou can debug the code if you want to see line by line.");

        ObjectOne objectOne = new ObjectOne.Builder()
                .setAttributeOne("AttributeOne Here")
                .setAttributeTwo("AttributeTwo here")
                .build();


    }

}
