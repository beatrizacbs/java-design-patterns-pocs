package vc.com.justa.factory.classes;

public abstract class BaseClass {

    private int something;

    public BaseClass(int something){
        this.something = something;
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "something='" + something + '\'' +
                '}';
    }

    public abstract void doSomething();
}
