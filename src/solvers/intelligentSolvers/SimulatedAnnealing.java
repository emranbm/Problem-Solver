package solvers.intelligentSolvers;

import models.NoState;
import models.Problem;
import models.State;
import solvers.Solver;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class SimulatedAnnealing implements Solver {

    private int stepCounter = 0;
    private int maxSteps;
    private State currentState;
    private Problem problem;
    private TFunction tFunction;

    private int seenStates = 0;
    private int maxNodesInRam = -1;

    /**
     * @param problem  Note that the given problem <b>h</b> method, should represent a value of a state, instead of a heuristic function.
     * @param maxSteps Maximum steps to go for finding a good-value state.
     */
    public SimulatedAnnealing(Problem problem, TFunction tFunction, int maxSteps) {
        this.maxSteps = maxSteps;
        this.problem = problem;
        this.currentState = problem.startState();
        this.tFunction = tFunction;
    }

    @Override
    public State tick() {

        if (stepCounter == maxSteps)
            return currentState == null ? new NoState() : currentState;

        ArrayList<State> neighbors = problem.getNeighbors(currentState);

        int neighborCount = neighbors.size();

        if (neighborCount > maxNodesInRam)
            maxNodesInRam = neighborCount;

        State suggestion = neighbors.get((int) (Math.random() * neighborCount));

        if (problem.h(suggestion) >= problem.h(currentState) || Math.random() < this.tFunction.p(stepCounter)) {
            currentState = suggestion;
            seenStates++;
        }

        stepCounter++;

        return null;
    }

    @Override
    public int getSeenStatesCount() {
        return seenStates;
    }

    @Override
    public int getExpandedCount() {
        return seenStates;
    }

    @Override
    public int maxNodesInRAM() {
        return maxNodesInRam;
    }

    public interface TFunction {
        /**
         * The probability of taking a worse state in neighborhood. Note that, this method should be a non-incremental function.
         *
         * @param step The total steps spent up to now.
         * @return The probability. (Between 0 and 1)
         */
        double p(int step);
    }
}
