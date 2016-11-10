package samples.eightQueens;

import models.Action;
import models.Problem;
import models.State;

import java.util.ArrayList;

/**
 * Created by emran on 11/6/16.
 */
public class EightQueensProblem extends Problem {
    @Override
    public State startState() {
        return new CheckerState(0, 0, 1, 2, 3, 4, 5, 6, 7);
    }

    @Override
    public boolean isGoal(State state) {
        int[] p = ((CheckerState) state).getPermutation();

        for (int i = 0; i < p.length; i++)
            for(int j = i + 1; j < p.length;j++) {
                if (p[i] == p[j])
                    return false;

                if(j - i == Math.abs(p[i] - p[j]))
                    return false;
            }

        return true;
    }

    @Override
    public ArrayList<Action> availableActions(State state) {
        ArrayList<Action> actions = new ArrayList<>();


        for (int i = 0; i < 8; i++)
            for (int j = i + 1; j < 8; j++) {
                int[] a = ((CheckerState) state).getPermutation();

                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;

                State s = new CheckerState((int) (Math.random() * Integer.MAX_VALUE), a);

                actions.add(new Action(s, 1));
            }

        return actions;
    }
}
