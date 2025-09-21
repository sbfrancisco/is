package org.example;
import org.example.cells.Cell;
import org.example.concrete.strategy.*;
import org.example.interfaces.RuleColors;
import org.example.interfaces.StrategyDisplay;
import org.example.observers.observers.Observer;
import org.example.observers.observers.StadisticDisplay;
import org.example.observers.observers.StadisticRuleDisplay;
import org.example.observers.observers.StatusDisplay;
import org.example.observers.subject.Subject;
import org.example.rules.Immigration;

import java.util.LinkedList;
import java.util.List;

import static org.example.utils.Utils.initMatrix;

public class GameOfLife implements Subject {
    StatsGameOfLife stats;
    List<Observer> observers;
    Cell[][] matrix;
    StrategyDisplay strategyDisplay;
    RuleColors rc;
    Observer stadisticRuleDisplay;
    Observer statusDisplay;
    Observer stadisticDisplay;

    public GameOfLife(Cell[][] matrix) {
        this.matrix = matrix;
        stats = new StatsGameOfLife();
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

    public void setStrategyDisplay(StrategyDisplay strategyDisplay) {
        this.strategyDisplay = strategyDisplay;
    }

    public void display() throws InterruptedException {
        strategyDisplay.display(matrix);
    }

    public void computeNextGeneration() {
        Cell[][] next = getEmptyTable();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                processCell(row,col,next);
            }
        }
        stats.registerNextGeneration();
        stats.collectGenerationInfo(matrix, next);
        setNextGeneration(next);
        stats.collectColorCellInfo();
        notifyObservers();
        resetStatsOfGame();
    }

    private void processCell(int row, int col, Cell[][] board) {
        Cell cell = rc.checkRule(row, col, matrix);
        board[row][col] = cell;
        stats.collectCellInfo(cell);
    }
    private Cell[][] getEmptyTable() {
        int row = matrix.length;
        int col = matrix[0].length;
        return new Cell[row][col];
    }

    private void setNextGeneration(Cell[][] board){
        this.matrix = board;
    }

    private void resetStatsOfGame() {
        stats = new StatsGameOfLife();
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public void notifyObservers(){
        for(Observer o : observers){
            o.update(this.stats);
        }
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }




}
