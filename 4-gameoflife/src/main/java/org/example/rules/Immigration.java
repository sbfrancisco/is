package org.example.rules;

import org.example.cells.Cell;
import org.example.concrete.Counter;
import org.example.concrete.factory.concreteCellFactory;
import org.example.interfaces.CellFactory;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.RuleColors;
import org.example.types.Direction;
import java.util.*;

import static org.example.utils.Utils.*;

public class Immigration implements RuleColors {
    String rule;

    public Immigration() {
        this.rule = "B3/S23";
    }

    @Override
    public Cell checkRule(int n, int m, Cell[][] matrix) {
        CellFactory cf = new concreteCellFactory();
        ArrayList<Set<Character>> params = parseRule(rule);
        Set<Character> neighbors = params.get(0);       // condiciones de nacimiento (B)
        Set<Character> live_neighbors = params.get(1);  // condiciones de supervivencia (S)
        int count_live_neighbors = 0;
        ColorCounter counter = new Counter();

        // Recorro vecinos
        for (Direction d : Direction.getNeighbors()) {
            int x_prime = d.x + n;
            int y_prime = d.y + m;

            if (isValid(x_prime, y_prime, matrix)) {
                Cell cell = matrix[x_prime][y_prime];
                if (cell.getState()) {
                    count_live_neighbors++;
                    String color = cell.getColor();
                    if (color != null) {
                        counter.incrementColor(color);
                    }
                }
            }
        }

        if (!matrix[n][m].getState()) {
            for (Character c : neighbors) {
                if (count_live_neighbors == Integer.parseInt(c.toString())) {
                    String color = counter.getMayority();
                    return cf.createCell(color);
                }
            }
        } else {
            for (Character c : live_neighbors) {
                if (count_live_neighbors == Integer.parseInt(c.toString())) {
                    return matrix[n][m];
                }
            }
        }
        return cf.createCell("dead");
    }
}
