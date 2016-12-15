package solvers.intelligentSolvers;

import models.Problem;
import models.State;
import solvers.Solver;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class HillClimbingRandom implements Solver {

    private Problem problem;
    private State currentState;

    private int maxNodesInRam = -1;
    private int seenStates = 0;
    private int expandedStates = 0;

    /**
     * @param problem Note that the given problem <b>h</b> method, should represent a value of a state, instead of a heuristic function.
     */
    public HillClimbingRandom(Problem problem) {
        this.problem = problem;
        this.currentState = problem.startState();
    }

    @Override
    public State tick() {
        ArrayList<State> neighbors = problem.getNeighbors(currentState);
        expandedStates++;

        int neighborCount = neighbors.size();

        seenStates += neighborCount;

        if (neighborCount > maxNodesInRam)
            maxNodesInRam = neighborCount;

        ArrayList<State> nexts = new ArrayList<>();

        for (State state : neighbors) {
            if (problem.h(state) > problem.h(currentState))
                nexts.add(state);
        }

        if (nexts.size() == 0)
            return currentState;
        else
            currentState = nexts.get((int) (Math.random() * nexts.size()));

        return null;
    }

    @Override
    public int getSeenStatesCount() {
        return seenStates;
    }

    @Override
    public int getExpandedCount() {
        return expandedStates;
    }

    @Override
    public int maxNodesInRAM() {
        return maxNodesInRam;
    }
}
