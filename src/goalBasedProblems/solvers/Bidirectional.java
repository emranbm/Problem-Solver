package goalBasedProblems.solvers;

import goalBasedProblems.models.LinkedState;
import goalBasedProblems.models.GoalBasedProblem;
import goalBasedProblems.models.State;
import utils.Helper;
import utils.Solver;

import java.util.ArrayList;

/**
 * Created by emran on 10/31/16.
 */
public class Bidirectional implements Solver {

    private TreeBasedBFS solver1, solver2;
    private LinkedState finalState;

    /**
     * @param goalBasedProblem
     * @throws ClassCastException If the GoalBasedProblem final or start state is not an instance of {@link LinkedState LinkedState}.
     */
    public Bidirectional(GoalBasedProblem goalBasedProblem) throws ClassCastException {
        finalState = (LinkedState) goalBasedProblem.finalState();
        solver1 = new TreeBasedBFS(goalBasedProblem);
        solver2 = new TreeBasedBFS(Helper.overrideStartState(goalBasedProblem, finalState));
    }

    @Override
    public State tick() {

        State newState1 = solver1.tick();
        if (newState1 != null)
            return newState1;
        State newState2 = solver2.tick();
        if (newState2 != null)
            return newState2;

        LinkedState intersection;

        if ((intersection = (LinkedState) getIntersection(solver1.seenStates, solver2.seenStates)) != null) {
            reverseParents(finalState, intersection);
            return finalState;
        } else
            return null;
    }

    private static void reverseParents(LinkedState start, LinkedState end) {
        if (start.equals(end))
            return;
        if (end.getParent().equals(start)) {
            start.setParent(end);
            return;
        }

        LinkedState child, parent, grandparent;

        child = null;
        parent = end;
        grandparent = parent.getParent();

        while (grandparent != null && !start.equals(parent)) {
            child = parent;
            parent = grandparent;
            grandparent = grandparent.getParent();

            parent.setParent(child);
        }
    }

    private static State getIntersection(ArrayList<State> a1, ArrayList<State> a2) {
        for (State s1 : a1)
            for (State s2 : a2)
                if (s1 == s2)
                    return s2;

        return null;
    }

    @Override
    public int getSeenStatesCount() {
        return solver1.getSeenStatesCount() + solver2.getSeenStatesCount();
    }

    @Override
    public int getExpandedCount() {
        return solver1.getExpandedCount() + solver2.getExpandedCount();
    }

    @Override
    public int maxNodesInRAM() {
        return solver1.maxNodesInRAM() + solver2.maxNodesInRAM();
    }
}
