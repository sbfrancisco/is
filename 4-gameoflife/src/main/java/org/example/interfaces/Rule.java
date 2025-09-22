package org.example.interfaces;

import org.example.GameOfLife;
import org.example.cells.Cell;

public interface Rule {
    Cell checkRule(int n, int m, GameOfLife game);
}
