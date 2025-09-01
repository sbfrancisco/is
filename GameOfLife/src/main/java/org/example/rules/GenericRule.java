package org.example.rules;
import org.example.Direction;
import org.example.interfaces.IUtils;
import org.example.interfaces.Rule;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.Set;

public class GenericRule implements Rule {
    String rule;
    public GenericRule(String rule) {
        this.rule = rule;
    }

    public boolean checkRule(int n, int m, int[][] matrix) {
        IUtils u = new Utils();
        ArrayList<Set<Character>> params = u.parseRule(rule);
        Set<Character> neighbors = params.get(0);
        Set<Character> live_neighbors = params.get(1);

        int count_live_neighbors = 0;

        for (Direction d : Direction.getNeighbors()) {
            int x_prime = d.x + n; // x'
            int y_prime = d.y + m; // y'
            if (u.isValid(x_prime, y_prime,matrix)) {
                if (matrix[x_prime][y_prime] == 1) {
                    count_live_neighbors++;
                }
            }
        }
        if(matrix[n][m]==0){
            for(Character c : neighbors){
                if(count_live_neighbors==Integer.parseInt(c.toString())){
                    return true;
                }
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
}
