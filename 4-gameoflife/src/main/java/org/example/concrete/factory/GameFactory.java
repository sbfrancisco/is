package org.example.concrete.factory;

import org.example.GameOfLife;
import org.example.interfaces.IGameFactory;

public class GameFactory {
    IGameFactory gameFactoryGUI;
    IGameFactory gameFactoryConsole;
    public GameFactory() {
        gameFactoryGUI = new concreteGameGUIFactory();
        gameFactoryConsole = new concreteConsoleGameFactory();
    }

    public GameOfLife createGame(String display, String game, int row, int col) {
        if(display.equals("console")){
            return gameFactoryConsole.createGameOfLife(game, row, col);
        } else {
            return gameFactoryGUI.createGameOfLife(game, row, col);
        }
    }

}
