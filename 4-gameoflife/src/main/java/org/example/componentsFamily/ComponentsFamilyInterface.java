package org.example.componentsFamily;

import org.example.interfaces.Color;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.Rule;

public interface ComponentsFamilyInterface {
    public Rule createRule();
    public Color[] createColors();
    public ColorCounter createCounter();
}

