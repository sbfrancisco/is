package org.example.pull.concrete;

import org.example.pull.interfaces.Observer;
import org.example.pull.interfaces.Subject;

import java.util.List;

public class ConcreteSubject implements Subject {
  int volume;
  List<Observer> observers;
    @Override
    public void registerObserver(Observer o) {
      observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for(Observer o : observers){
            o.update(this);
        }
    }

    public int getVolume() {
      return volume;
    }

}
