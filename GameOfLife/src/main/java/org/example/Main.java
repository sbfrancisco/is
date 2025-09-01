package org.example;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[3][8];
        matrix[0][4] = 1;
        matrix[1][3] = 1;
        matrix[1][4] = 1;
        GameOfLife gol = new GameOfLife(matrix, "B3/S23");
        printMatrix(gol.getMatrix());
        gol.execute();
        printMatrix(gol.getMatrix());
        gol.execute();
        printMatrix(gol.getMatrix());
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // salto de línea después de cada fila
        }
        System.out.println(); // espacio extra entre generaciones
    }

}
