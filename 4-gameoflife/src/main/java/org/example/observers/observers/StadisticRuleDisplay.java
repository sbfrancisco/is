package org.example.observers.observers;

import org.example.observers.subject.CellCounter;

import static org.example.Main.iterations;

public class StadisticRuleDisplay implements Observer, DisplayStats {
    CellCounter cellCounter;
    int goal;
    int rule_birt;
    int rule_dead;
    int rule_survive;

    public StadisticRuleDisplay(CellCounter cellCounter, int goal) {
        this.cellCounter = cellCounter;
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
    public void update(int count_red, int count_blue, int count_white, int rule_birt, int rule_dead, int rule_survive, int ruleSurvive) {
        this.rule_birt += rule_birt;
        this.rule_dead += rule_dead;
        this.rule_survive += rule_survive;
        if(iterations == goal){
            display();
        }
    }
}
