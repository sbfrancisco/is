package org.example.observers.observers;

public interface Observer {
    void update(int count_red, int count_blue, int count_white, int count_dead,  int rule_birt, int rule_dead, int rule_survive);
}
