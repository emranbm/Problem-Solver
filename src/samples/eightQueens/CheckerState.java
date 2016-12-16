package samples.eightQueens;

import models.goalBased.State;

/**
 * Created by emran on 11/6/16.
 */
public class CheckerState extends State {

    private int[] permutation;

    public CheckerState(int[] permutation) {
        this.permutation = permutation.clone();
    }

    public CheckerState(int q0, int q1, int q2, int q3, int q4, int q5, int q6, int q7) {
        this(new int[]{q0, q1, q2, q3, q4, q5, q6, q7});
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

    @Override
    public String describeSelf() {
        String self = "[";
        for (int i : permutation)
            self += i + ", ";

        self = self.substring(0,self.length() - 2) + "]";

        return self;
    }
}
