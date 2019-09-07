package vc.com.justa.observer.observers;

import vc.com.justa.observer.subjects.BaseSubject;

public class ObserverTwo extends ObserverAbstract{

    public ObserverTwo(BaseSubject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Updates the ObserverTwo with the state: " + subject.getState());
    }
}
