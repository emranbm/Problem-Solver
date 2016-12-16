package solvers.constraintSolvers;

import models.constraintSatisfaction.Answer;
import models.constraintSatisfaction.ConstraintProblem;
import models.goalBased.State;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class HillClimbingSimple implements ConstraintSolver {

    private ConstraintProblem constraintProblem;
    private Answer currentAnswer;

    private int maxNodesInRam = -1;
    private int seenStates = 0;
    private int expandedStates = 0;

    /**
     * @param constraintProblem Note that the given GoalBasedProblem <b>h</b> method, should represent a value of a state, instead of a heuristic function.
     */
    public HillClimbingSimple(ConstraintProblem constraintProblem) {
        this.constraintProblem = constraintProblem;
        this.currentAnswer = constraintProblem.initialAnswer();
    }

    @Override
    public Answer tick() {
        ArrayList<Answer> neighbors = constraintProblem.neighbors(currentAnswer);
        expandedStates++;

        int neighborCount = neighbors.size();

        seenStates += neighborCount;

        if (neighborCount > maxNodesInRam)
            maxNodesInRam = neighborCount;

        Answer bestAnswer = currentAnswer;
        for (Answer answer : neighbors) {
            if (answer.value() > bestAnswer.value())
                bestAnswer = answer;
        }

        if (bestAnswer == currentAnswer)
            return currentAnswer;
        else
            currentAnswer = bestAnswer;

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
