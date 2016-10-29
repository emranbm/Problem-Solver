package models;

/**
 * Created by emran on 10/29/16.
 */
public class Action {

    private State nextState;
    private int cost;

    public Action(State nextState, int cost) {
        this.nextState = nextState;
        this.cost = cost;
    }

    public State getNextState() {
        return nextState;
    }

    public int getCost() {
        return cost;
    }
}
