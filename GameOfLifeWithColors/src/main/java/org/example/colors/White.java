package org.example.colors;
import org.example.interfaces.Colors;

public class White extends GenericColor implements Colors {
    String color;
    public White() { super("WHITE"); }

    @Override
    public boolean isAlive() {
        return false;
    }
}
