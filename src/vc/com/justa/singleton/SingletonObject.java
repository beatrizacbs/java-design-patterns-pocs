package vc.com.justa.singleton;

/**
 * This class represents an object with the singleton design pattern
 */
public class SingletonObject {

    /**
     * It has the attribute <b>instance</b> that is the only instance created of this object
     */
    private static SingletonObject instance;

    //TODO: You can put other attributes here as you wish, but it cannot infer in the pattern.

    /**
     * A private empty constructor so it is not possible to create another instanceof this object
     */
    private SingletonObject(){
    }

    /**
     * The method <i>getInstance()</i> is the only way you can access the <b>single instance</b> of the object
     * @return th single instance possible of an object
     */
    public static SingletonObject getInstance(){
        if(instance == null){
            System.out.println("Creates the new instance because it is required for the first time");
            instance = new SingletonObject();
        }else{
            System.out.println("Uses already created instance.");
        }
        return instance;
    }

}
