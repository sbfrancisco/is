package org.example.push.concrete;

import org.example.push.interfaces.Observer;
import org.example.push.interfaces.Subject;

import java.util.List;

public class ConcreteSubject implements Subject {
    int volume;
    List<Observer> observers;

    public ConcreteSubject(int volume) {
        this.volume = volume;
    }

    public void changeVolume(int volume) {
        this.volume = volume;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
      for (Observer o : observers) {
          o.update(volume);
      }
    }

    @Override
    public boolean containsObserver(Observer o) {
        return observers.contains(o);
    }


}
