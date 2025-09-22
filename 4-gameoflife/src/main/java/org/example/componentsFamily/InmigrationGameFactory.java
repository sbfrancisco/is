package org.example.componentsFamily;

import org.example.colors.Blue;
import org.example.colors.Red;
import org.example.colors.White;
import org.example.concrete.Counter;
import org.example.interfaces.Color;
import org.example.interfaces.ColorCounter;
import org.example.interfaces.Rule;
import org.example.rules.Inmigration;

public class InmigrationGameFactory implements ComponentsFamilyInterface {

    @Override
    public Rule createRule() {
        return new Inmigration();
    }

    @Override
    public Color[] createColors() {
        return new  Color[]{new Blue(), new White(), new Red()};
    }

    @Override
    public ColorCounter createCounter() {
        return new Counter(this.createColors());
    }

}
