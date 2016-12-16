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
public class GraphBasedDFS implements GoalBasedSolver {

    private GoalBasedProblem goalBasedProblem;
    protected LinkedList<StateDepthBundle> queue;

    private int expanded = 0;
    private int seen = 1;
    private int maxNodesInRAM = 0;

    protected int maxDepth;

    public GraphBasedDFS(GoalBasedProblem goalBasedProblem, int maxDepth) {
        this.goalBasedProblem = goalBasedProblem;
        this.queue = new LinkedList<>();
        this.queue.add(new StateDepthBundle(goalBasedProblem.startState(), 0));
        this.maxDepth = maxDepth;
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

        for (State state : children) {

            if (state instanceof LinkedState)
                ((LinkedState) state).setParent((LinkedState) currentBundle.state);

            seen++;
            if (goalBasedProblem.isGoal(state))
                return state;

            queue.add(new StateDepthBundle(state, nextDepth));
        }


//        queue.addAll(children);

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
