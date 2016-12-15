package models;

import java.util.ArrayList;

/**
 * Created by emran on 10/29/16.
 */
public abstract class Problem {

    /**
     * Returns the starting state of the problem.
     */
    public abstract State startState();

    /**
     * Returns all the available actions that can be taken in the given state.
     *
     * @param state The state to get actions from.
     * @return All actions that is suitable in the given state.
     */
    public abstract ArrayList<Action> availableActions(State state);

    public abstract State actionResult(State state, Action action);

    /**
     * Returns all states available from the given state.
     *
     * @param state The parent state
     * @return All states that the parent can reach them by an action.
     */
    public ArrayList<State> getNeighbors(State state) {
        ArrayList<Action> actions = availableActions(state);
        ArrayList<State> children = new ArrayList<>();

        for (Action action : actions)
            children.add(actionResult(state, action));

        return children;
    }

    /**
     * Determines if a state is goal or not.
     *
     * @param state The state to be checked.
     */
    public abstract boolean isGoal(State state);

    /**
     * The total cost of a path, starting from the start state and taking the given actions.
     *
     * @param actions The actions to take, from the start state.
     * @return Total cost.
     */
    public int pathCost(ArrayList<Action> actions) {
        int result = 0;
        for (Action action : actions)
            result += action.getCost();

        return result;
    }

    /**
     * Heuristic function.
     *
     * @param state The current state.
     * @return An integer representing how far we are from the goal. (Lower is better) (The minimum should be 0)
     */
    public int h(State state) {
        return 0;
    }

    /**
     * The cost spent from start to the given state.
     *
     * @param state
     * @return
     */
    public int g(State state) {
        return 0;
    }

    public State finalState() {
        return null;
    }
}
