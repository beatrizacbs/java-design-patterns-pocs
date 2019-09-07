package vc.com.justa.state.context;

import vc.com.justa.state.states.StateInterface;

/**
 * The context where the states are
 */
public class ContextClass {

    private StateInterface stateInterface;

    public ContextClass(){
        stateInterface = null;
    }

    public StateInterface getState() {
        return stateInterface;
    }

    /**
     * Change the state of that determined context
     * @param stateInterface the new state
     */
    public void setState(StateInterface stateInterface) {
        this.stateInterface = stateInterface;
        System.out.println(String.format("State of the context %s changed to: %s", this.toString(), stateInterface.toString()));
    }
}
