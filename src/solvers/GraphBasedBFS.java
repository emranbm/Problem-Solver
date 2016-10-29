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

    public GraphBasedBFS(Problem problem) {
        this.problem = problem;
        queue = new LinkedList<>();
        queue.add(problem.startState());
    }

    @Override
    public State tick() {
        State currentState = queue.poll();
        ArrayList<State> children = currentState.getChildren();

        queue.addAll(children);

        return problem.isGoal(currentState) ? currentState : null;
    }
}
