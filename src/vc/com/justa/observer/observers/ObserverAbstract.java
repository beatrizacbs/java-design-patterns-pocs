package vc.com.justa.observer.observers;

import vc.com.justa.observer.subjects.BaseSubject;

/**
 * the abstract class that has to be implemented by all the observers who want to be notified in the subject change
 */
public abstract class ObserverAbstract {

    protected BaseSubject subject;
    public abstract void update();

}
