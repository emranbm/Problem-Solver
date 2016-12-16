package solvers.constraintSolvers;

import models.constraintSatisfaction.Answer;
import models.constraintSatisfaction.ConstraintProblem;
import models.goalBased.GoalBasedProblem;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class HillClimbingRandom implements ConstraintSolver {

    private ConstraintProblem constraintProblem;
    private Answer currentAnswer;

    private int maxNodesInRam = -1;
    private int seenStates = 0;
    private int expandedStates = 0;

    /**
     * @param constraintProblem Note that the given constraintProblem <b>h</b> method, should represent a value of a state, instead of a heuristic function.
     */
    public HillClimbingRandom(ConstraintProblem constraintProblem) {
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

        ArrayList<Answer> nexts = new ArrayList<>();

        for (Answer answer : neighbors) {
            if (answer.value() > currentAnswer.value())
                nexts.add(answer);
        }

        if (nexts.size() == 0)
            return currentAnswer;
        else
            currentAnswer = nexts.get((int) (Math.random() * nexts.size()));

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
