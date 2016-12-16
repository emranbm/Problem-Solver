package CSP.solvers;

import CSP.models.Answer;
import CSP.models.ConstraintProblem;
import CSP.models.NoAnswer;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class HillClimbingFirstChoice implements ConstraintSolver {

    private ConstraintProblem problem;
    private Answer currentAnswer;
    private int maxRandomTries;

    private int maxNodesInRam = -1;
    private int seenStates = 0;
    private int expandedStates = 0;

    /**
     * @param problem
     * @param maxRandomTries Maximum number of random tries on neighbors to find a better neighbor. If no better neighbor achieved in these tries, the current state will be returned as the best result.
     */
    public HillClimbingFirstChoice(ConstraintProblem problem, int maxRandomTries) {
        this.problem = problem;
        this.currentAnswer = problem.initialAnswer();
        this.maxRandomTries = maxRandomTries;
    }

    @Override
    public Answer tick() {
        ArrayList<Answer> neighbors = problem.neighbors(currentAnswer);
        expandedStates++;

        int neighborCount = neighbors.size();

        seenStates += neighborCount;

        if (neighborCount > maxNodesInRam)
            maxNodesInRam = neighborCount;

        boolean betterFound = false;

        for (int i = 0; i < maxRandomTries; i++) {
            Answer neighb = neighbors.get((int) (Math.random() * neighborCount));
            if (neighb.value() > currentAnswer.value()) {
                currentAnswer = neighb;
                betterFound = true;
                break;
            }
        }

        if (!betterFound)
            return currentAnswer == null ? new NoAnswer() : currentAnswer;

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
