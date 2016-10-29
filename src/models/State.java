package models;

import java.util.ArrayList;

/**
 * A model representing the state in a problem. Feel free to extend this class to implement your own state.
 * <p>
 * Created by emran on 10/29/16.
 */
public class State {

    private int id;
    private ArrayList<Action> actions;

    public State(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public final void addAction(Action action) {
        actions.add(action);
    }

    public final ArrayList<Action> getActions() {
        return (ArrayList<Action>) actions.clone();
    }
}
