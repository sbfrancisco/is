package org.example.interfaces;

import org.example.cells.Cell;

public interface CellFactory {
    Cell createCell(String color);
}
