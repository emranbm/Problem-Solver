package solvers;

import models.Problem;
import models.State;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by emran on 10/29/16.
 */
public class GraphBasedDFS implements Solver {

    private Problem problem;
    private LinkedList<State> queue;

    private int expanded = 0;
    private int seen = 1;
    private int maxNodesInRAM = 0;

    public GraphBasedDFS(Problem problem) {
        this.problem = problem;
        this.queue = new LinkedList<>();
        this.queue.add(problem.startState());
    }

    @Override
    public State tick() {
        State currentState = queue.getLast();
        queue.remove(queue.size() - 1);
        ArrayList<State> children = currentState.getChildren();

        expanded++;

        for (State state : children) {
            seen++;
            if (problem.isGoal(state))
                return state;
            queue.addFirst(state);
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
