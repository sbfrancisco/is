package org.example.utils;

import org.example.cells.Cell;
import org.example.colors.Blue;
import org.example.colors.Red;
import org.example.colors.White;
import org.example.interfaces.Colors;
import org.example.types.State;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Utils{
    public static ArrayList<Set<Character>> parseRule(String rule) {
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

    public static boolean isValid(int n, int m, Cell[][] matrix) {
        return (n >= 0 && n < matrix.length && m >= 0 && m < matrix[0].length);
    }

    public static Cell newCell(String color) {
        if (color.equals("WHITE")) {
            return new Cell(new White());
        } else if (color.equals("BLUE")) {
            return new Cell(new Blue());
        } else if (color.equals("RED")) {
            return new Cell(new Red());
        }
        return null;
      }
    public static void initMatrix(Cell[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                Cell c = newCell("WHITE");
                m[i][j] = c;
            }
        }
     }
    }
