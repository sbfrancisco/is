package org.example;
import org.example.cells.Cell;
import org.example.colors.Blue;
import org.example.colors.White;
import org.example.concrete.Counter;
import org.example.concrete.strategy.*;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.Rule;
import org.example.interfaces.RuleColors;
import org.example.interfaces.StrategyDisplay;
import org.example.observers.observers.Observer;
import org.example.observers.observers.StadisticDisplay;
import org.example.observers.observers.StadisticRuleDisplay;
import org.example.observers.observers.StatusDisplay;
import org.example.observers.subject.CellCounter;
import org.example.rules.Immigration;
import org.example.rules.StandardRule;
import org.example.types.State;

import java.util.HashMap;
import java.util.Map;

import static org.example.Main.iterations;
import static org.example.utils.Utils.initMatrix;

public class GameOfLife {
    public static int birt_cells;
    public static int survive_cells;
    public static int dead_cells;
    // represent live neighbors with 1, dead with 0
    Cell[][] matrix;
    StrategyDisplay strategyDisplay;
    RuleColors rc;
    CellCounter counters;
    Observer stadisticRuleDisplay;
    Observer statusDisplay;
    Observer stadisticDisplay;

    public GameOfLife(Cell[][] matrix) {
        counters = new CellCounter();
        statusDisplay = new StatusDisplay(counters);
        stadisticDisplay = new StadisticDisplay(counters, 15); // 15 is objetive of print
        stadisticRuleDisplay = new StadisticRuleDisplay(counters,15);
        counters.registerObserver(statusDisplay);
        counters.registerObserver(stadisticDisplay);
        counters.registerObserver(stadisticRuleDisplay);
        this.matrix = matrix;
        initMatrix(this.matrix);
        rc = new Immigration();
        strategyDisplay = new BlackAliveWhiteDeadDisplay();
    }

    public void setStrategyDisplay(StrategyDisplay strategyDisplay) {
        this.strategyDisplay = strategyDisplay;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public void execute() {
        int n = matrix.length;
        int m = matrix[0].length;
        Cell[][] next = new Cell[n][m];
        ColorCounter counter = new Counter();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Cell c =  rc.checkRule(i, j, matrix);
                if (!c.toString().equals("dead")) {
                    counter.incrementColor(c.getColor());
                }
                next[i][j] = c;
            }
        }
        register(counter);
        matrix = next;
    }
    public void register(ColorCounter colorCounter) {
        HashMap<String,Integer> cc = (HashMap<String, Integer>) colorCounter.getCounters();
        int counter_red = cc.get("RED");
        int counter_white = cc.get("WHITE");
        int count_blue = cc.get("BLUE");
        int count_dead = matrix.length *  matrix[0].length - (count_blue) - counter_white - counter_red;
        counters.setState(counter_red, counter_white, count_blue, count_dead, birt_cells, survive_cells, dead_cells);
        restartRules();
    }

    public void display() throws InterruptedException {
        strategyDisplay.display(matrix);
    }

    public void restartRules(){
        birt_cells = 0;
        survive_cells = 0;
        dead_cells = 0;
    }
}
