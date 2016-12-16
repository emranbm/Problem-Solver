package goalBasedProblems.samples.eightQueens;

import goalBasedProblems.models.Action;

/**
 * Created by emran on 11/11/16.
 */
public class CheckerAction extends Action {

    private int i, j;

    /**
     * The action to swap ith and jth element.
     *
     * @param i
     * @param j
     */
    public CheckerAction(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
