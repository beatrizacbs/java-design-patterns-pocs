package vc.com.justa.observer.subjects;

import vc.com.justa.observer.observers.ObserverAbstract;

import java.util.ArrayList;
import java.util.List;

/**
 * The subject that is going to be changed in the observer
 */
public class BaseSubject {

    private List<ObserverAbstract> observers = new ArrayList<>();
    private int state;

    public int getState(){
        return state;
    }

    /**
     * Makes a modification in the subject, so it has to notify all the observables
     * @param state
     */
    public void setState(int state){
        this.state = state;
        notifyAllObservers();
    }

    /**
     * Attaches a new observer to be notified when the subject changes
     * @param observer the new observer
     */
    public void attach(ObserverAbstract observer){
        System.out.println("Attatched a new Observer");
        observers.add(observer);
    }

    /**
     * Notifies and updates all the observables in the list of observables under this subject
     */
    public void notifyAllObservers(){
        System.out.println("There was a change. All observers are being notified");
        observers.forEach(ObserverAbstract::update);
    }

}
