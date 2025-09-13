package org.example.observers.subject;

import org.example.observers.observers.Observer;
import java.util.ArrayList;
import java.util.List;

public class CellCounter implements Subject {
    int counter_blue;
    int counter_red;
    int counter_white;
    int counter_dead;
    int rule_survive;
    int rule_birt;
    int rule_dead;
    List<Observer> observers;

    public CellCounter() {
        observers = new ArrayList<Observer>();
    }
    public void setState(int counter_red, int counter_white, int counter_blue, int count_dead,
                         int birtCells, int surviveCells, int deadCells) {
        this.counter_blue = counter_blue;
        this.counter_red = counter_red;
        this.counter_white = counter_white;
        this.counter_dead = count_dead;
        this.rule_birt = birtCells;
        this.rule_dead = deadCells;
        this.rule_survive = surviveCells;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(){
        for(Observer o : observers){
           o.update(counter_red, counter_blue, counter_white, counter_dead, rule_birt, rule_dead, rule_survive);
        }
    }
}

