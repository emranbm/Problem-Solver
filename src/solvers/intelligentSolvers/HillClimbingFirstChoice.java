package solvers.intelligentSolvers;

import models.NoState;
import models.Problem;
import models.State;
import solvers.Solver;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class HillClimbingFirstChoice implements Solver {

    private Problem problem;
    private State currentState;
    private int maxRandomTries;

    private int maxNodesInRam = -1;
    private int seenStates = 0;
    private int expandedStates = 0;

    /**
     * @param problem        Note that the given problem <b>h</b> method, should represent a value of a state, instead of a heuristic function.
     * @param maxRandomTries Maximum number of random tries on neighbors to find a better neighbor. If no better neighbor achieved in these tries, the current state will be returned as the best result.
     */
    public HillClimbingFirstChoice(Problem problem, int maxRandomTries) {
        this.problem = problem;
        this.currentState = problem.startState();
        this.maxRandomTries = maxRandomTries;
    }

    @Override
    public State tick() {
        ArrayList<State> neighbors = problem.getNeighbors(currentState);
        expandedStates++;

        int neighborCount = neighbors.size();

        seenStates += neighborCount;

        if (neighborCount > maxNodesInRam)
            maxNodesInRam = neighborCount;

        boolean betterFound = false;

        for (int i = 0; i < maxRandomTries; i++) {
            State neighb = neighbors.get((int) (Math.random() * neighborCount));
            if (problem.h(neighb) > problem.h(currentState)) {
                currentState = neighb;
                betterFound = true;
                break;
            }
        }

        if (!betterFound)
            return currentState == null ? new NoState() : currentState;

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
