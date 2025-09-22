package org.example.interfaces;

import org.example.GameOfLife;

public interface IGameFactory {
    GameOfLife createGameOfLife(String game, int row, int col);
}
