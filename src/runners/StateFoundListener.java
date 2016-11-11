package runners;

import models.State;

import java.util.ArrayList;

/**
 * Created by emran on 11/10/16.
 */
public interface StateFoundListener {

    /**
     *
     * @param state
     * @param path @Nullable
     */
    void found(State state, ArrayList<State> path);
}
