package goalBasedProblems.solvers;

import goalBasedProblems.models.GoalBasedProblem;
import goalBasedProblems.models.LinkedState;
import goalBasedProblems.models.NoState;
import goalBasedProblems.models.State;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by emran on 10/29/16.
 */
public class TreeBasedDFS extends TreeBasedSolver {
    protected LinkedList<StateDepthBundle> queue;
    private GoalBasedProblem goalBasedProblem;

    private int expanded = 0;
    private int seen = 1;
    private int maxNodesInRAM = 0;

    protected int maxDepth;

    public TreeBasedDFS(GoalBasedProblem goalBasedProblem, int maxDepth) {
        this.goalBasedProblem = goalBasedProblem;
        queue = new LinkedList<>();
        queue.add(new StateDepthBundle(goalBasedProblem.startState(), 0));
        this.maxDepth = maxDepth;
        seenStates.add(goalBasedProblem.startState());
    }

    @Override
    public State tick() {
        StateDepthBundle currentBundle;
        try {
            currentBundle = queue.getLast();
        } catch (Exception e) {
            // Nothing finished in the given max depth.
            return new NoState();
        }
        queue.remove(queue.size() - 1);
        ArrayList<State> children = goalBasedProblem.getChildren(currentBundle.state);
        expanded++;

        int nextDepth = currentBundle.depth + 1;

        if (nextDepth > maxDepth)
            return null;

        for (int i = children.size() - 1; i >= 0; i--) {
            if (seenStates.contains(children.get(i)))
                children.remove(i);
        }


        for (State state : children) {

            if (state instanceof LinkedState)
                ((LinkedState) state).setParent((LinkedState) currentBundle.state);

            seen++;
            seenStates.add(state);
            if (goalBasedProblem.isGoal(state))
                return state;

            //queue.addAll(children);
            queue.add(new StateDepthBundle(state, nextDepth));
        }


        if (queue.size() > maxNodesInRAM)
            maxNodesInRAM = queue.size();

        return null;
    }

    @Override
    public int getSeenStatesCount() {
        return seen;
    }

    @Override
    public int getExpandedCount() {
        return expanded;
    }

    @Override
    public int maxNodesInRAM() {
        return maxNodesInRAM;
    }
}
