package org.example.rules;
import org.example.GameOfLife;
import org.example.concrete.factory.concreteCellFactory;
import org.example.interfaces.CellFactory;
import org.example.types.Direction;
import org.example.interfaces.Rule;
import org.example.cells.Cell;
import java.util.ArrayList;
import java.util.Set;

import static org.example.utils.Utils.isValid;
import static org.example.utils.Utils.parseRule;

public class GenericRule implements Rule {
    String rule;

    public GenericRule(String rule) {
        this.rule = rule;
    }

    public Cell checkRule(int n, int m, GameOfLife game) {
        CellFactory cf = new concreteCellFactory();
        ArrayList<Set<Character>> params = parseRule(rule);
        Set<Character> neighbors = params.get(0);       // nacimientos (B)
        Set<Character> live_neighbors = params.get(1);  // supervivencias (S)
        Cell[][] matrix = game.getMatrix();
        int count_live_neighbors = 0;

        for (Direction d : Direction.getNeighbors()) {
            int x_prime = d.x + n;
            int y_prime = d.y + m;

            if (isValid(x_prime, y_prime, matrix)) {
                if (matrix[x_prime][y_prime].getState()) {
                    count_live_neighbors++;
                }
            }
        }

        // una vez contados los vecinos, aplico la regla
        if (!matrix[n][m].getState()) {
            for (Character c : neighbors) { // "B"
                if (count_live_neighbors == Integer.parseInt(c.toString())) {
                    return cf.createCell("white"); // por defecto las vivas son blancas
                }
            }
        } else {
            for (Character c : live_neighbors) { // "S"
                if (count_live_neighbors == Integer.parseInt(c.toString())) {
                    return matrix[n][m];
                }
            }
        }
        return cf.createCell("dead");
    }

}
