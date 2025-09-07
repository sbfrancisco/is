package org.example.push.concrete;

import org.example.push.interfaces.Observer;
import org.example.push.interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class ControllerChromecast implements Subject {
    int volume;
    List<Observer> observers;

    public ControllerChromecast() {
        this.volume = 100;
        this.observers = new ArrayList<>();
    }

    public void changeVolume(int volume) {
        this.volume = volume;
        notifyObservers();
    }

    public boolean containsObserver(Observer o) {
        return observers.contains(o);
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


}
