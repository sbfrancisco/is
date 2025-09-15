package org.example.observers.observers;

import org.example.GameOfLife;

public class StadisticDisplay implements Observer, DisplayStats {
    GameOfLife game;
    int goal;
    int cell_alive;
    int cell_dead;

    public StadisticDisplay(GameOfLife game, int goal) {
        this.cell_alive = 0;
        this.cell_dead = 0;
        this.game = game;
        this.goal = goal;
    }

    @Override
    public void update(GameOfLife game){
        this.cell_alive += game.getCellAlives();
        this.cell_dead += game.getCellDead();
        if(goal==game.getGenerations()){
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("info of stadistic display");
        System.out.println("the average of cells live is: " + (cell_alive / goal));
        System.out.println("the average of cells dead is: " + (cell_dead / goal));
        System.out.println();
    }
}
