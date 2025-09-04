package org.example;

import org.example.cells.Cell;

import static org.example.utils.Utils.initMatrix;
import static org.example.utils.Utils.newCell;

public class Main {
    public static void main(String[] args) {
        Cell[][] matrix = new Cell[3][8];
        initMatrix(matrix);
        matrix[0][4] = newCell("RED");
        matrix[0][3] = newCell("RED");
        matrix[1][4] = newCell("BLUE");
        GameOfLife gol = new GameOfLife(matrix);
        printMatrix(gol.getMatrix());
        gol.execute();
        printMatrix(gol.getMatrix());
    }
    public static void printMatrix(Cell[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j].toString() + " ");
            }
            System.out.println(); // salto de línea después de cada fila
        }
        System.out.println(); // espacio extra entre generaciones
    }



}
