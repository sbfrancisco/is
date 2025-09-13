package org.example.observers.observers;

import org.example.observers.subject.CellCounter;

import static org.example.Main.iterations;

public class StadisticDisplay implements Observer, DisplayStats {
    int color_blue;
    int color_red;
    int color_white;
    int cell_dead;
    int objetive;
    CellCounter cc;

    public StadisticDisplay(CellCounter cc, int objetive) {
        this.color_blue = 0;
        this.color_red = 0;
        this.color_white = 0;
        this.cell_dead = 0;
        this.cc = cc;
        this.objetive = objetive;
    }

    @Override
    public void update(int count_red, int count_blue, int count_white, int count_dead, int rule_birt, int rule_dead, int rule_survive){
        this.color_blue += count_blue;
        this.color_red += count_red;
        this.color_white += count_white;
        this.cell_dead += count_dead;
        if(iterations == 15) {
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("info of stadistic display");
        int total = color_blue + color_red + color_white;
        System.out.println("the average of cells live is: " + total /objetive);
        System.out.println("the average of cells dead is: " + cell_dead /objetive);
        System.out.println();
    }
}
