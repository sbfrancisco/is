package org.example.componentsFamily;

import org.example.colors.White;
import org.example.concrete.Counter;
import org.example.interfaces.Color;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.Rule;
import org.example.rules.StandardRule;

public class ClassicGameFamilyFactory implements ComponentsFamilyInterface {

    public Rule createRule(){
        return new StandardRule();
    }

    public Color[] createColors(){
        return new Color[]{ new White()};
    }

    public ColorCounter createCounter(){
        return new Counter(this.createColors());
    }
}
