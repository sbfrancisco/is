package org.example.interfaces;

import java.util.Map;

public interface ColorCounter {
    void incrementColor(String color);
    Map<String,Integer> getCounters();
    String getMayority();
}
