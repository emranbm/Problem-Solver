package solvers.goalBasedSolvers;

import models.goalBased.GoalBasedProblem;
import models.goalBased.LinkedState;
import models.goalBased.State;
import solvers.Solver;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A graph-based BFS search. It means duplicate states may be checked more than one time.
 * Created by emran on 10/29/16.
 */
public class GraphBasedBFS implements Solver {

    private LinkedList<State> queue;
    private GoalBasedProblem goalBasedProblem;

    private int expanded = 0;
    private int seen = 1;
    private int maxNodesInRAM = 0;

    public GraphBasedBFS(GoalBasedProblem goalBasedProblem) {
        this.goalBasedProblem = goalBasedProblem;
        queue = new LinkedList<>();
        queue.add(goalBasedProblem.startState());
    }

    @Override
    public State tick() {
        State currentState = queue.poll();
        ArrayList<State> children = goalBasedProblem.getChildren(currentState);

        expanded++;

        for (State state : children) {

            if(state instanceof LinkedState)
                ((LinkedState) state).setParent((LinkedState) currentState);

            seen++;
            if (goalBasedProblem.isGoal(state))
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
