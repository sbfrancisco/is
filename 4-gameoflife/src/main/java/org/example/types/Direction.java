package org.example.types;

public class Direction{
    public int x;
    public int y;
    public Direction(int x, int y){
        this.x = x;
        this.y = y;
    }
    public static Direction[] getNeighbors(){
        return new Direction[]{new Direction(-1, 1), new Direction(-1, -1),
                new Direction(0,-1),new Direction(-1, 0), new Direction(1,-1),
                new Direction(1,0), new  Direction(1, 1), new  Direction(0, 1),};
    }
}