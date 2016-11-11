package samples.pathFinder;

import models.Action;

/**
 * Created by emran on 11/11/16.
 */
public class CellAction extends Action {

    private int dx, dy;

    public CellAction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
