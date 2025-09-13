package org.example.concrete.strategy;

import org.example.cells.Cell;
import org.example.interfaces.StrategyDisplay;

public class StandardDisplay implements StrategyDisplay {
    public void display(Cell[][] matrix) {
        for(Cell[] cells: matrix){
            for(Cell cell: cells){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
