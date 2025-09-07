package org.example.push.interfaces;

public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    boolean containsObserver(Observer o);
}
