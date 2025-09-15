package org.example.observers.observers;

import org.example.GameOfLife;

public class StadisticRuleDisplay implements Observer, DisplayStats {
    GameOfLife game;
    int goal;
    int rule_birt;
    int rule_dead;
    int rule_survive;

    public StadisticRuleDisplay(GameOfLife game, int goal) {
        this.game = game;
        this.goal = goal;
    }

    @Override
    public void display() {
        System.out.println("Rule Stadistics Display");
        System.out.println("the average of rule birt apply is:" + rule_birt/goal);
        System.out.println("the average of rule dead apply is:" + rule_dead/goal);
        System.out.println("the average of rule survive apply is:" + rule_survive/goal);
    }

    @Override
    public void update(GameOfLife game) {
        this.rule_birt += game.getRuleBirt();
        this.rule_dead += game.getRuleDead();
        this.rule_survive += game.getRuleSurvive();
        if(game.getGenerations() == goal){
            display();
        }
    }
}
