package org.example.rules;

import org.example.cells.Cell;
import org.example.colors.Blue;
import org.example.colors.Red;
import org.example.colors.White;
import org.example.interfaces.Colors;
import org.example.interfaces.Rule;
import org.example.interfaces.RuleColors;
import org.example.types.Direction;

import java.util.*;

import static org.example.utils.Utils.*;

public class Immigration implements RuleColors {
    String rule;
    HashMap<String, Integer> neighbors_colors;

    public Immigration() {
        this.rule = "B3/S23";
        neighbors_colors = new HashMap<>();
    }

    @Override
    public Cell checkRule(int n, int m, Cell[][] matrix) {
        ArrayList<Set<Character>> params = parseRule(rule);
        Set<Character> neighbors = params.get(0);
        neighbors_colors = new HashMap<>();
        ArrayList<Colors> colors = new ArrayList<>(List.of(new Blue(), new Red()));
        for (Colors c : colors) {
            neighbors_colors.put(c.getColor(), 0);
        }

        Set<Character> live_neighbors = params.get(1);
        int count_live_neighbors = 0;
        for (Direction d : Direction.getNeighbors()) {
            int x_prime = d.x + n;
            int y_prime = d.y + m;

            if (isValid(x_prime, y_prime, matrix)) {
                Cell cell = matrix[x_prime][y_prime];
                if (cell.getState()) {
                    count_live_neighbors++;
                    neighbors_colors.put(cell.getColor(), neighbors_colors.get(cell.getColor()) + 1);
                }
            }
            if (!matrix[n][m].getState()) {
                for (Character c : neighbors) { // "B"
                    if (count_live_neighbors == Integer.parseInt(c.toString())) {
                        String color = getMayority();
                       System.out.println(color);
                        Cell temp = newCell(color);
                        return temp;
                    }
                }
            } else {
                for (Character c : live_neighbors) { // "S"
                    if (count_live_neighbors == Integer.parseInt(c.toString())) {
                       return matrix[n][m];
                    }
                }
            }
        }
        return newCell("WHITE");
    }

    public String getMayority(){
      Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : neighbors_colors.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        if(maxEntry != null){
          return maxEntry.getKey();
         }
         return null;
    }

}