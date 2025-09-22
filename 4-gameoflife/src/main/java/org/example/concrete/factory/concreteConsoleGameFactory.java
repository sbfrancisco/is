package org.example.concrete.factory;

import org.example.GameOfLife;
import org.example.componentsFamily.ClassicGameFamilyFactory;
import org.example.componentsFamily.HighLifeFamilyFactory;
import org.example.componentsFamily.InmigrationGameFactory;
import org.example.concrete.strategy.StandardDisplay;
import org.example.interfaces.IGameFactory;
import org.example.interfaces.StrategyDisplay;

public class concreteConsoleGameFactory implements IGameFactory {
    @Override
    public GameOfLife createGameOfLife(String game, int row, int col){
        StrategyDisplay strategyDisplay = new StandardDisplay();
        GameOfLife gof = null;
        if(game.equals("highlife")){
            gof = new GameOfLife(new HighLifeFamilyFactory(), row, col);
        } else if (game.equals("classic")){
            gof = new GameOfLife(new ClassicGameFamilyFactory(), row, col);
        } else if (game.equals("inmigration")) {
            gof = new GameOfLife(new InmigrationGameFactory(), row, col);
        }
        gof.setStrategyDisplay(strategyDisplay);
        return gof;
    }
}
