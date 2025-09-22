package org.example.componentsFamily;

import org.example.colors.White;
import org.example.concrete.Counter;
import org.example.interfaces.Color;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.Rule;
import org.example.rules.HighLifeRule;

public class HighLifeFamilyFactory implements ComponentsFamilyInterface {

    @Override
    public Rule createRule() {
        return new HighLifeRule();
    }

    @Override
    public Color[] createColors() {
        return new Color[]{ new White()};
    }

    @Override
    public ColorCounter createCounter() {
        return new Counter(this.createColors());
    }

}
