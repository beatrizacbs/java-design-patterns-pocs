package vc.com.justa.strategy.context;

import vc.com.justa.strategy.interfaces.StrategyInterface;

/**
 * This class communicates with the strategy interface.
 */
public class BaseContext {

    private StrategyInterface strategyInterface;

    public BaseContext(StrategyInterface strategyInterface){
        this.strategyInterface = strategyInterface;
    }

    /**
     * Method that executes the strategy based in the implementation of each strategy passed.
     * @param something Represents the attribute (or attributes) to be used in the function.
     */
    public void executeStrategy(String something){
        System.out.println("Enters the executeStrategy() method and calls the interface method passing: " + strategyInterface);
        strategyInterface.doSomething(something);
    }
}
