package samples.eightQueens;

import models.Action;
import models.State;

/**
 * Created by emran on 11/6/16.
 */
public class CheckerState extends State {

    private int[] permutation;

    public CheckerState(int id, int[] permutation) {
        super(id);
        this.permutation = permutation.clone();
    }

    public CheckerState(int id, int q0, int q1, int q2, int q3, int q4, int q5, int q6, int q7) {
        this(id, new int[]{q0, q1, q2, q3, q4, q5, q6, q7});
    }

    public CheckerState(int id, CheckerState cloner) {
        this(id, cloner.getPermutation());
    }

    public int[] getPermutation() {
        return permutation.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CheckerState))
            return false;

        CheckerState checkerState = ((CheckerState) obj);

        if (checkerState.permutation.length != this.permutation.length)
            return false;

        for (int i = 0; i < this.permutation.length; i++)
            if (this.permutation[i] != checkerState.permutation[i])
                return false;

        return true;
    }
}
