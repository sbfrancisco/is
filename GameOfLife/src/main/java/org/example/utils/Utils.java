package org.example.utils;

import org.example.interfaces.IUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
public class Utils implements IUtils {
    public ArrayList<Set<Character>> parseRule(String rule) {
        ArrayList<Set<Character>> result = new ArrayList<>();
        String[] process = rule.split("/"); // ["B3", "S23"]

        // Números para células que nacen
        char[] bornArray = process[0].substring(1).toCharArray(); // quitar la "B"
        Set<Character> born = new HashSet<>();
        for (char c : bornArray) {
            born.add(c);
        }

        // Números para células que sobreviven
        char[] surviveArray = process[1].substring(1).toCharArray(); // quitar la "S"
        Set<Character> survive = new HashSet<>();
        for (char c : surviveArray) {
            survive.add(c);
        }

        result.add(born);
        result.add(survive);

        return result;
    }

    public boolean isValid(int n, int m, int[][] matrix) {
        return (n >= 0 && n < matrix.length && m >= 0 && m < matrix[0].length);
    }
}
