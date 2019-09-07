package vc.com.justa.state.states;

import vc.com.justa.state.context.ContextClass;

/**
 * Defines the contract that the state has to have
 */
public interface StateInterface {
    public void doAction(ContextClass contextClass);
}
