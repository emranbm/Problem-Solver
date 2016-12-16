package CSP.solvers;

import CSP.models.Answer;
import CSP.models.ConstraintProblem;
import CSP.models.NoAnswer;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class SimulatedAnnealing implements ConstraintSolver {

    private int stepCounter = 0;
    private int maxSteps;
    private Answer currentAnswer;
    private ConstraintProblem constraintProblem;
    private TFunction tFunction;

    private int seenStates = 0;
    private int maxNodesInRam = -1;

    /**
     * @param constraintProblem  Note that the given GoalBasedProblem <b>h</b> method, should represent a value of a state, instead of a heuristic function.
     * @param maxSteps Maximum steps to go for finding a good-value state.
     */
    public SimulatedAnnealing(ConstraintProblem constraintProblem, TFunction tFunction, int maxSteps) {
        this.maxSteps = maxSteps;
        this.constraintProblem = constraintProblem;
        this.currentAnswer = constraintProblem.initialAnswer();
        this.tFunction = tFunction;
    }

    @Override
    public Answer tick() {

        if (stepCounter == maxSteps)
            return currentAnswer == null ? new NoAnswer() : currentAnswer;

        ArrayList<Answer> neighbors = constraintProblem.neighbors(currentAnswer);

        int neighborCount = neighbors.size();

        if (neighborCount > maxNodesInRam)
            maxNodesInRam = neighborCount;

        Answer suggestion = neighbors.get((int) (Math.random() * neighborCount));

        if (suggestion.value() >= currentAnswer.value() || Math.random() < this.tFunction.p(stepCounter)) {
            currentAnswer = suggestion;
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
