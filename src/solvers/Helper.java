package solvers;

import models.Action;
import models.Problem;
import models.State;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class Helper {

    /**
     * Replaces the start state of the given problem with a custom state.
     *
     * @param problem
     * @param newStartState
     * @return A problem which its start state is exactly the newStartState.
     */
    public static Problem overrideStartState(Problem problem, State newStartState) {
        return new Problem() {
            @Override
            public State startState() {
                return newStartState;
            }

            @Override
            public boolean isGoal(State state) {
                return problem.isGoal(state);
            }

            @Override
            public ArrayList<Action> availableActions(State state) {
                return problem.availableActions(state);
            }

            @Override
            public State actionResult(State state, Action action) {
                return problem.actionResult(state, action);
            }

            @Override
            public int pathCost(ArrayList<Action> actions) {
                return problem.pathCost(actions);
            }

            @Override
            public int h(State state) {
                return problem.h(state);
            }

            @Override
            public int g(State state) {
                return problem.g(state);
            }
        };
    }
}
