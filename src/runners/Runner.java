package runners;

import goalBasedProblems.models.LinkedState;
import Solver;

import java.util.ArrayList;

/**
 * Created by emran on 10/29/16.
 */
public class Runner extends Thread {

    private Solver solver;
    private StateFoundListener listener;

    public Runner(Solver solver) {
        this.solver = solver;
    }

    public Runner(Solver solver, StateFoundListener listener) {
        this(solver);
        this.listener = listener;
    }

    @Override
    public void run() {
        goalBasedProblems.models.State goal = null;
        while (goal == null) {
            goal = solver.tick();
        }

        if (goal instanceof LinkedState) {
            LinkedState state = (LinkedState) goal;

            ArrayList<goalBasedProblems.models.State> path = new ArrayList<>();

            while (state != null) {
                path.add(state);
                state = state.getParent();
            }

            path = reversePath(path);

            this.listener.found(goal, path);
        } else
            this.listener.found(goal, null);
    }

    private static ArrayList<goalBasedProblems.models.State> reversePath(ArrayList<goalBasedProblems.models.State> path) {
        ArrayList<goalBasedProblems.models.State> reverse = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--)
            reverse.add(path.get(i));

        return reverse;
    }
}
