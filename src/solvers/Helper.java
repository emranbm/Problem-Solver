package solvers;

import models.constraintSatisfaction.Answer;
import models.constraintSatisfaction.ConstraintProblem;
import models.goalBased.Action;
import models.goalBased.GoalBasedProblem;
import models.goalBased.State;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class Helper {

    /**
     * Replaces the start state of the given GoalBasedProblem with a custom state.
     *
     * @param goalBasedProblem
     * @param newStartState
     * @return A GoalBasedProblem which its start state is exactly the newStartState.
     */
    public static GoalBasedProblem overrideStartState(GoalBasedProblem goalBasedProblem, State newStartState) {
        return new GoalBasedProblem() {
            @Override
            public State startState() {
                return newStartState;
            }

            @Override
            public boolean isGoal(State state) {
                return goalBasedProblem.isGoal(state);
            }

            @Override
            public ArrayList<Action> availableActions(State state) {
                return goalBasedProblem.availableActions(state);
            }

            @Override
            public State actionResult(State state, Action action) {
                return goalBasedProblem.actionResult(state, action);
            }

            @Override
            public int pathCost(ArrayList<Action> actions) {
                return goalBasedProblem.pathCost(actions);
            }

            @Override
            public int h(State state) {
                return goalBasedProblem.h(state);
            }

            @Override
            public int g(State state) {
                return goalBasedProblem.g(state);
            }
        };
    }

    /**
     * Replaces the initial answer of the given ConstraintProblem with a custom answer.
     *
     * @param constraintProblem
     * @param newInitialAnswer
     * @return A ConstraintProblem which its initial answer is exactly the newInitialAnswer.
     */
    public static ConstraintProblem overrideInitialAnswer(ConstraintProblem constraintProblem, Answer newInitialAnswer) {
        return new ConstraintProblem() {
            @Override
            public ArrayList<Answer> neighbors(Answer answer) {
                return constraintProblem.neighbors(answer);
            }

            @Override
            public Answer initialAnswer() {
                return newInitialAnswer;
            }
        };
    }
}
