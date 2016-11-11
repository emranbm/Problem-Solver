package samples.pathFinder;

import models.LinkedState;

/**
 * Created by emran on 11/11/16.
 */
public class Cell extends LinkedState {

    private int x, y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String describeSelf() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cell))
            return false;

        return ((Cell) obj).x == this.x && ((Cell) obj).y == this.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
