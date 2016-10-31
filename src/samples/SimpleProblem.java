package samples;

import models.Action;
import models.Problem;
import models.State;

import java.util.ArrayList;

/**
 * Created by emran on 10/29/16.
 */
public class SimpleProblem extends Problem {

    private ArrayList<State> states;

    public SimpleProblem() {
        states = new ArrayList<>();

        for (int i = 0; i < 5; i++)
            states.add(new State(i));

        setActions();
    }

    private void setActions() {
        states.get(0).addAction(new Action(states.get(1), 1));
        states.get(0).addAction(new Action(states.get(2), 1));
        states.get(1).addAction(new Action(states.get(3), 1));
        states.get(2).addAction(new Action(states.get(3), 1));
        states.get(3).addAction(new Action(states.get(4), 1));
    }

    @Override
    public State startState() {
        return states.get(0);
    }

    @Override
    public boolean isGoal(State state) {
        return state.getId() == 4;
    }
}
