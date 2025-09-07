package org.example.push.concrete;

import org.example.push.interfaces.Observer;

public class ConcreteObserver implements Observer {
    ConcreteSubject subject;
    int volume;
    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
    }
    @Override
    public void update(Object o) {
        this.volume = (Integer) o;
    }
}
