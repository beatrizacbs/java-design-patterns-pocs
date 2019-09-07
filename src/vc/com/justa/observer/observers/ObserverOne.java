package vc.com.justa.observer.observers;

import vc.com.justa.observer.subjects.BaseSubject;

public class ObserverOne extends ObserverAbstract {

    public ObserverOne(BaseSubject subject){
        this.subject = subject;
        this.subject.attach(this);

    }

    @Override
    public void update() {
        System.out.println("Updates the ObserverOne with the state: " + subject.getState());
    }
}
