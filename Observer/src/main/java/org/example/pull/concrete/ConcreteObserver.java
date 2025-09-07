package org.example.pull.concrete;

import org.example.pull.interfaces.Observer;
import org.example.pull.interfaces.Subject;

import java.util.List;

public class ConcreteObserver implements Observer {
    int volume;
    @Override
    public void update(Subject s) {
        ConcreteSubject process = (ConcreteSubject) s;
        this.volume = process.getVolume();
    }
}
