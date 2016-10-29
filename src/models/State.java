package models;

/**
 * A model representing the state in a problem. Feel free to extend this class to implement your own state.
 * <p>
 * Created by emran on 10/29/16.
 */
public class State {

    private int id;

    public State(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
