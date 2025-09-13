package org.example;

import org.example.cells.Cell;
import org.example.concrete.factory.concreteCellFactory;
import org.example.concrete.strategy.*;
import org.example.interfaces.CellFactory;

public class Main {
 public static int iterations = 0;
    public static void main(String[] args) throws InterruptedException {
        CellFactory cf = new concreteCellFactory();
        Cell[][] matrix = new Cell[5][10];
        GameOfLife gol = new GameOfLife(matrix);

        matrix[1][2] = cf.createCell("RED");
        matrix[1][3] = cf.createCell("RED");
        matrix[1][4] = cf.createCell("RED");

        matrix[3][5] = cf.createCell("BLUE");
        matrix[4][5] = cf.createCell("BLUE");
        matrix[2][5] = cf.createCell("BLUE");

        gol.setStrategyDisplay(new FramerDisplayColors());

        for(int i = 0; i < 20; i++){
            iterations++;
            gol.display();
            gol.execute();
            System.out.println();
        }
    }
}

