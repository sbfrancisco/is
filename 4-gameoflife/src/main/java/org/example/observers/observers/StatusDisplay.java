package org.example.observers.observers;

import org.example.observers.subject.CellCounter;

public class StatusDisplay implements Observer, DisplayStats {
    CellCounter cellCounter;
    int red = 0;
    int white = 0;
    int blue = 0;
    int dead = 0;

    public StatusDisplay(CellCounter cellCounter) {
        this.cellCounter = cellCounter;
    }

    @Override
    public void update(int count_red, int count_blue, int count_white, int count_dead, int rule_birt, int rule_, int ruleSurvive) {
     this.red = count_red;
     this.white = count_white;
     this.blue = count_blue;
     this.dead = count_dead;
     display();
    }

    @Override
    public void display() {
        System.out.println("info of status display");
        System.out.println("has registered " + blue + " cells blue");
        System.out.println("has registered " + red + " cells red");
        System.out.println("has registered " + white + " cells white");
        System.out.println("has registered " + dead + " cells dead");
        System.out.println();
    }
}
