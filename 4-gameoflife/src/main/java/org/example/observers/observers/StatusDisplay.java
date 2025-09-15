package org.example.observers.observers;

import org.example.GameOfLife;

public class StatusDisplay implements Observer, DisplayStats {
    GameOfLife game;
    int red = 0;
    int white = 0;
    int blue = 0;
    int dead = 0;

    public StatusDisplay(GameOfLife game) {
        this.game = game;
    }

    @Override
    public void update(GameOfLife game) {
     this.red = game.getCellRed();
     this.white = game.getCellWhite();
     this.blue = game.getCellBlue();
     this.dead = game.getCellDead();
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
