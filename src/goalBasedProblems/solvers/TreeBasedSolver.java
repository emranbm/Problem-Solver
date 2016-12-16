package goalBasedProblems.solvers;

import goalBasedProblems.models.State;

import java.util.ArrayList;

/**
 * Created by emran on 10/31/16.
 */
public abstract class TreeBasedSolver implements GoalBasedSolver {

    protected ArrayList<State> seenStates;

    public TreeBasedSolver() {
        seenStates = new ArrayList<>();
    }

    public ArrayList<State> getSeenStates() {
        return (ArrayList<State>) seenStates.clone();
    }
}
