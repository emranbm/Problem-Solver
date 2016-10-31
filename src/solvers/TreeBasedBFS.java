package solvers;

import models.Problem;
import models.State;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by emran on 10/29/16.
 */
public class TreeBasedBFS extends TreeBasedSolver {
    private LinkedList<State> queue;
    private Problem problem;

    private int expanded = 0;
    private int seen = 1;
    private int maxNodesInRAM = 0;

    public TreeBasedBFS(Problem problem) {
        this.problem = problem;
        seenStates = new ArrayList<>();
        queue = new LinkedList<>();
        queue.add(problem.startState());
    }

    @Override
    public State tick() {
        State currentState = queue.poll();
        ArrayList<State> children = currentState.getChildren();
        expanded++;

        for (int i = children.size() - 1; i >= 0; i--) {
            if (seenStates.contains(children.get(i)))
                children.remove(i);
        }


        for (State state : children) {
            seen++;
            seenStates.add(state);
            if (problem.isGoal(state))
                return state;
        }

        queue.addAll(children);

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
