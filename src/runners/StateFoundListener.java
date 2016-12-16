package runners;

import goalBasedProblems.models.State;

import java.util.ArrayList;

/**
 * Created by emran on 11/10/16.
 */
public interface StateFoundListener extends SolveFinishedListener {

    void pathFound(ArrayList<State> path);
}
