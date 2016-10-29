package solvers;

import models.Problem;
import models.State;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A graph-based BFS search. It means duplicate states may be checked more than one time.
 * Created by emran on 10/29/16.
 */
public class GraphBasedBFS implements Solver {

    private LinkedList<State> queue;
    private Problem problem;

    private int seenAndExpanded = 0;
    private int maxNodesInRAM = 0;

    public GraphBasedBFS(Problem problem) {
        this.problem = problem;
        queue = new LinkedList<>();
        queue.add(problem.startState());
    }

    @Override
    public State tick() {
        State currentState = queue.poll();
        ArrayList<State> children = currentState.getChildren();

        seenAndExpanded++;

        queue.addAll(children);

        if (queue.size() > maxNodesInRAM)
            maxNodesInRAM = queue.size();

        return problem.isGoal(currentState) ? currentState : null;
    }

    @Override
    public int getSeenStatesCount() {
        return seenAndExpanded;
    }

    @Override
    public int getExpandedCount() {
        return seenAndExpanded;
    }

    @Override
    public int maxNodesInRAM() {
        return maxNodesInRAM;
    }
}
