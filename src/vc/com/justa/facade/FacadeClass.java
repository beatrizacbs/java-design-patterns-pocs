package vc.com.justa.facade;

public class FacadeClass {

    /**
     * Method that runs a complicated task
     */
    public void doSomething(){
        System.out.println("Enters facade method");
        BaseOne baseOne = new BaseOne();
        BaseTwo baseTwo = new BaseTwo();
        baseOne.doSomethingBaseOne();
        baseTwo.doSomethingBaseTwo();
    }
}
