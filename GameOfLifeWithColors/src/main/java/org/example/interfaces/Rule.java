package org.example.interfaces;

import org.example.cells.Cell;

public interface Rule {
    boolean checkRule(int n, int m, Cell[][] matrix);
}
