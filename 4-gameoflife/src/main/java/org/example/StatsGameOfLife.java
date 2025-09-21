package org.example;

import org.example.cells.Cell;
import org.example.concrete.Counter;
import org.example.interfaces.ColorCounter;

public class StatsGameOfLife {
    int cell_red, cell_white, cell_blue;
    int cell_alive;
    int cell_dead;
    int generations;
    int rule_survive;
    int rule_birt;
    int rule_dead;
    ColorCounter counter;

    public StatsGameOfLife(){
        cell_red = 0;
        cell_white = 0;
        cell_blue = 0;
        cell_alive = 0;
        cell_dead = 0;
        generations = 0;
        rule_survive = 0;
        rule_birt = 0;
        rule_dead = 0;
        counter = new Counter();
    }

    public int getGenerations() { return generations; }

    public int getCellAlives(){ return cell_alive; }

    public int getCellDead(){ return cell_dead; }

    public int getCellRed(){ return cell_red; }

    public int getCellWhite(){ return cell_white; }

    public int getCellBlue(){ return cell_blue; }

    public int getRuleSurvive(){ return rule_survive; }

    public int getRuleBirt(){ return rule_birt; }

    public int getRuleDead(){ return rule_dead; }

    public void collectColorCellInfo(){
        this.cell_blue = counter.getCounterColor("BLUE");
        this.cell_red = counter.getCounterColor("RED");
        this.cell_white = counter.getCounterColor("WHITE");
    }

    public void registerNextGeneration(){
        generations++;
    }
    public void collectCellInfo(Cell cell){
        if(isAlive(cell)){
            String colorCell = cell.getColor();
            incrementCountLiveCell();
            incrementCountColorCell(colorCell);
        } else {
            incrementCountCellDead();
        }
    }

    private boolean isAlive(Cell c) {
        return c.getState();
    }

    private void incrementCountColorCell(String color){
            counter.incrementColor(color);
    }


    public void collectGenerationInfo(Cell[][] old_table, Cell[][] new_table) {
        for(int i = 0; i < old_table.length; i++) {
            for(int j = 0; j < old_table[0].length; j++) {
                if(!old_table[i][j].getState() && new_table[i][j].getState()) {
                    rule_birt++;
                }
                if(old_table[i][j].getState() && new_table[i][j].getState()) {
                    rule_survive++;
                }
                if(old_table[i][j].getState() && !new_table[i][j].getState()) {
                    rule_dead++;
                }
            }
        }
    }


    private void incrementCountCellDead(){
        cell_dead++;
    }

    private void incrementCountLiveCell(){
        cell_alive++;
    }

}
