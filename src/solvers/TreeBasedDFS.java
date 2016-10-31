package solvers;

import models.Problem;
import models.State;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by emran on 10/29/16.
 */
public class TreeBasedDFS implements Solver {
    protected LinkedList<StateDepthBundle> queue;
    private Problem problem;

    private int expanded = 0;
    private int seen = 1;
    private int maxNodesInRAM = 0;

    protected int maxDepth;

    private ArrayList<State> seenStates;

    public TreeBasedDFS(Problem problem, int maxDepth) {
        this.problem = problem;
        seenStates = new ArrayList<>();
        queue = new LinkedList<>();
        queue.add(new StateDepthBundle(problem.startState(), 0));
        this.maxDepth = maxDepth;
    }

    @Override
    public State tick() {
        StateDepthBundle currentBundle;
        try {
            currentBundle = queue.getLast();
        } catch (Exception e) {
            // Nothing found in the given max depth.
            return new State(-1);
        }
        queue.remove(queue.size() - 1);
        ArrayList<State> children = currentBundle.state.getChildren();
        expanded++;

        int nextDepth = currentBundle.depth + 1;

        if (nextDepth > maxDepth)
            return null;

        for (int i = children.size() - 1; i >= 0; i--) {
            if (seenStates.contains(children.get(i)))
                children.remove(i);
        }


        for (State state : children) {
            seen++;
            seenStates.add(state);
            if (problem.isGoal(state))
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