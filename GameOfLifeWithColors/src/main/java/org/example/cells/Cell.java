package org.example.cells;

import org.example.interfaces.Colors;
import org.example.types.State;

public class Cell {
    Colors color;
    public Cell(Colors color) {
        this.color = color;
    }

    public String getColor() { return this.color.getColor(); }

    public void setColor(Colors color) {
        this.color = color;
    }

    public boolean getState() {
        return color.isAlive();
    }

    public String toString(){
        String state;
        if(getState()){
            state = "ALIVE";
        } else {
            state = "DEAD";
        }
        return ("(" + state + ")" + getColor());
    }
}
