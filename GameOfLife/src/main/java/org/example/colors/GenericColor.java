package org.example.colors;

public class GenericColor {
    String color;
    public GenericColor(String color) {
        this.color = color;
    }
    public boolean isAlive(){
        return true;
    } // todas las celulas diferente a las blancas estan vivas
    public String getColor(){ return color; }
}
