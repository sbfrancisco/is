package org.example;
import org.example.cells.Cell;
import org.example.colors.Blue;
import org.example.colors.White;
import org.example.interfaces.Rule;
import org.example.interfaces.RuleColors;
import org.example.rules.Immigration;
import org.example.rules.StandardRule;
import org.example.types.State;

public class GameOfLife {
    // represent live neighbors with 1, dead with 0
    Cell[][] matrix;
    Rule r;
    RuleColors rc;

    public GameOfLife(Cell[][] matrix) {
        this.matrix = matrix;
        rc = new Immigration();
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
                Cell c =  rc.checkRule(i, j, matrix);
                   next[i][j] = c;
            }
        }
        matrix = next;
    }

}
