package vc.com.justa.state.states;

import vc.com.justa.state.context.ContextClass;

/**
 * One implementation of the StateInterface
 */
public class StateTwo implements StateInterface {

    @Override
    public void doAction(ContextClass contextClass) {
        contextClass.setState(this);
        System.out.println("The state now is 2 in the context: " + contextClass);
    }

    @Override
    public String toString() {
        return "StateTwo{}";
    }
}
