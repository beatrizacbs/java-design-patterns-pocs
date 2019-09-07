package vc.com.justa.factory.classes;

public class BaseClass {

    private String something;

    public BaseClass(String something){
        this.something = something;
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "something='" + something + '\'' +
                '}';
    }
}
