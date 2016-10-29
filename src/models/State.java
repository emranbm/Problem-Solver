package models;

import java.util.ArrayList;

/**
 * A model representing the state in a problem. Feel free to extend this class to implement your own state.
 * <p>
 * Created by emran on 10/29/16.
 */
public class State implements Cloneable {

    private int id;
    private ArrayList<Action> actions;
    private State parent;

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

    public final ArrayList<State> getChildren() {
        ArrayList<State> children = new ArrayList<>();

        for (Action action : actions)
            try {
                State child = (State) action.getResult().clone();
                child.setParent(this);
                children.add(child);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

        return children;
    }

    /**
     * Returns the parent of the current state.
     *
     * @return The previous state that came to this state.
     */
    public State getParent() {
        return parent;
    }

    /**
     * Sets the parent of the current state.
     *
     * @param parent The previous state that came to this state.
     */
    public void setParent(State parent) {
        this.parent = parent;
    }
}
