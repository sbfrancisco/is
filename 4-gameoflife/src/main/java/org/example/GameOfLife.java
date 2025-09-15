package org.example;
import org.example.cells.Cell;
import org.example.concrete.Counter;
import org.example.concrete.strategy.*;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.RuleColors;
import org.example.interfaces.StrategyDisplay;
import org.example.observers.observers.Observer;
import org.example.observers.observers.StadisticDisplay;
import org.example.observers.observers.StadisticRuleDisplay;
import org.example.observers.observers.StatusDisplay;
import org.example.observers.subject.Subject;
import org.example.rules.Immigration;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.example.utils.Utils.initMatrix;

public class GameOfLife implements Subject {
    int cell_red, cell_white, cell_blue;
    int cell_alives;
    int cell_dead;
    int generations;
    int rule_survive;
    int rule_birt;
    int rule_dead;
    List<Observer> observers;
    Cell[][] matrix;
    StrategyDisplay strategyDisplay;
    RuleColors rc;
    ColorCounter counter;
    Observer stadisticRuleDisplay;
    Observer statusDisplay;
    Observer stadisticDisplay;

    public GameOfLife(Cell[][] matrix) {
        this.matrix = matrix;
        counter = new Counter();
        initMatrix(this.matrix);
        rc = new Immigration();
        observers = new LinkedList<>();
        statusDisplay = new StatusDisplay(this);
        stadisticDisplay = new StadisticDisplay(this, 15); // 15 is objetive of print
        stadisticRuleDisplay = new StadisticRuleDisplay(this,15);
        registerObserver(statusDisplay);
        registerObserver(stadisticDisplay);
        registerObserver(stadisticRuleDisplay);
        strategyDisplay = new BlackAliveWhiteDeadDisplay();
    }

    public int getGenerations() { return generations; }

    public int getCellAlives(){ return cell_alives; }

    public int getCellDead(){ return cell_dead; }

    public int getCellRed(){ return cell_red; }

    public int getCellWhite(){ return cell_white; }

    public int getCellBlue(){ return cell_blue; }

    public int getRuleSurvive(){ return rule_survive; }

    public int getRuleBirt(){ return rule_birt; }

    public int getRuleDead(){ return rule_dead; }


    public void setStrategyDisplay(StrategyDisplay strategyDisplay) {
        this.strategyDisplay = strategyDisplay;
    }

    public void display() throws InterruptedException {
        strategyDisplay.display(matrix);
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public void execute() {
        int n = matrix.length;
        int m = matrix[0].length;
        Cell[][] next = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Cell cell = rc.checkRule(i,j,matrix);
                next[i][j] = cell;
                if(cell.getState()) {
                    cell_alives++;
                    counter.incrementColor(cell.getColor());
                } else {
                    cell_dead++;
                }
            }
        }
        generations++;
        getRules(matrix, next);
        matrix = next;
        setColors();
        notifyObservers();
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.update(this);
        }
        resetStats();
    }

    public void getRules(Cell[][] old_table, Cell[][] new_table) {
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

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setColors(){
        this.cell_blue = counter.getCounterColor("BLUE");
        this.cell_red = counter.getCounterColor("RED");
        this.cell_white = counter.getCounterColor("BLUE");
    }

    public void resetStats(){
        this.rule_survive = 0;
        this.rule_dead = 0;
        this.rule_birt = 0;
        this.cell_alives = 0;
        this.cell_dead = 0;
        counter = new Counter();
    }

}
