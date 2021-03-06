package goalBasedProblems.solvers;

import goalBasedProblems.models.GoalBasedProblem;
import goalBasedProblems.models.LinkedState;
import goalBasedProblems.models.State;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by emran on 10/30/16.
 */
public class UniformCost implements GoalBasedSolver {

    private LinkedList<State> queue;
    private GoalBasedProblem goalBasedProblem;

    private int expanded = 0;
    private int seen = 1;
    private int maxNodesInRAM = 0;

    private ArrayList<State> seenStates;

    public UniformCost(GoalBasedProblem goalBasedProblem) {
        this.goalBasedProblem = goalBasedProblem;
        seenStates = new ArrayList<>();
        queue = new LinkedList<>();
        queue.add(goalBasedProblem.startState());
    }

    @Override
    public State tick() {
        State currentState = queue.getFirst();

        for (State state : queue) {
            if (goalBasedProblem.g(state) < goalBasedProblem.g(currentState))
                currentState = state;
        }

        queue.remove(currentState);

        ArrayList<State> children = goalBasedProblem.getChildren(currentState);
        seen++;
        seenStates.add(currentState);
        if (goalBasedProblem.isGoal(currentState))
            return currentState;
        expanded++;

        for (int i = children.size() - 1; i >= 0; i--) {
            if (seenStates.contains(children.get(i)))
                children.remove(i);
        }

        for (State child : children)
            if (child instanceof LinkedState)
                ((LinkedState) child).setParent((LinkedState) currentState);

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
