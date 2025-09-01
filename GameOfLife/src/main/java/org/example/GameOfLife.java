package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class GameOfLife {
    // represent live neighbors with 1, dead with 0
    int[][] matrix;
    String rule;

    public GameOfLife(int[][] matrix , String rule) {
        this.matrix = matrix;
        this.rule = rule;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void execute() {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] next = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                next[i][j] = checkRule(i, j) ? 1 : 0;
            }
        }
        matrix = next;
    }


    private boolean checkRule(int n, int m) {
        ArrayList<char[]> params = processRule();
        char[] neighbors = params.get(0);
        String neighbors_expected = new String(neighbors);
        char[] live_neighbors = params.get(1);

        int count_live_neighbors = 0;

        for (Direction d : Direction.getNeighbors()) {
            int x_prime = d.x + n; // x'
            int y_prime = d.y + m; // y'
            if (isValid(x_prime, y_prime)) {
                if (matrix[x_prime][y_prime] == 1) {
                    count_live_neighbors++;
                }
            }
        }
        if(matrix[n][m]==0){
            if(count_live_neighbors == Integer.parseInt(neighbors_expected)){
                return true;
            }
        } else {
           for(Character c : live_neighbors){
               if(count_live_neighbors==Integer.parseInt(c.toString())){
                   return true;
               }
           }
        }
        return false;
    }

    private ArrayList<char[]> processRule() {
        ArrayList<char[]> result = new ArrayList<>();
        String[] process = rule.split("/");
        char[] na = process[0].toCharArray();
        char[] neighbors = Arrays.copyOfRange(na, 1, na.length); // quitar la "B"
        char[] nla = process[1].toCharArray();
        char[] live_neighbors = Arrays.copyOfRange(nla, 1, nla.length); // quitar la "S"
        result.add(neighbors);
        result.add(live_neighbors);
        return result;
    }

    public boolean isValid(int n, int m) {
        return (n >= 0 && n < matrix.length && m >= 0 && m < matrix[0].length);
    }
}
