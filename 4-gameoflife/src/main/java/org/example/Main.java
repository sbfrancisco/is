package org.example;

import org.example.cells.Cell;
import org.example.concrete.factory.GameFactory;
import org.example.concrete.factory.concreteCellFactory;
import org.example.concrete.factory.concreteGameGUIFactory;
import org.example.interfaces.CellFactory;
import org.example.interfaces.IGameFactory;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CellFactory cf = new concreteCellFactory();
        GameFactory gameFactory = new GameFactory();
        String display = "GUI";
        String game = "inmigration";
        int row = 5;
        int col = 8;
        GameOfLife gol = gameFactory.createGame(display, game, row, col);

        gol.matrix[1][2] = cf.createCell("RED");
        gol.matrix[1][3] = cf.createCell("RED");
        gol.matrix[1][4] = cf.createCell("RED");

        gol.matrix[3][5] = cf.createCell("BLUE");
        gol.matrix[4][5] = cf.createCell("BLUE");
        gol.matrix[2][5] = cf.createCell("BLUE");

        for(int i = 0; i < 20; i++){
            gol.display();
            gol.computeNextGeneration();
            System.out.println();
        }
    }

}

