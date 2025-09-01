package org.example;
import org.example.interfaces.IUtils;
import org.example.interfaces.Rule;
import org.example.rules.GenericRule;
import org.example.rules.StandardRule;
import org.example.utils.Utils;

import java.util.ArrayList;
public class GameOfLife {
    // represent live neighbors with 1, dead with 0
    int[][] matrix;
    Rule r;
    IUtils u;

    public GameOfLife(int[][] matrix) {
        this.matrix = matrix;
        r = new StandardRule();
        u = new Utils();
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
                next[i][j] = r.checkRule(i, j, matrix) ? 1 : 0;
            }
        }
        matrix = next;
    }

}
