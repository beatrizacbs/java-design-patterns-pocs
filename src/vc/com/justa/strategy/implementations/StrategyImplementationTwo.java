package vc.com.justa.strategy.implementations;

import vc.com.justa.strategy.interfaces.StrategyInterface;

/**
 * One implementation of the strategy interface
 */
public class StrategyImplementationTwo implements StrategyInterface {


    @Override
    public void doSomething(String something) {
        System.out.println("Does the thing in the second implementation: " + something);
    }
}
