package goalBasedProblems.solvers;

import goalBasedProblems.models.State;

/**
 * Created by emran on 10/29/16.
 */
public class StateDepthBundle {
    public StateDepthBundle(State state, int depth) {
        this.depth = depth;
        this.state = state;
    }

    int depth;
    State state;
}
