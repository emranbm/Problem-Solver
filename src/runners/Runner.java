package runners;

import goalBasedProblems.models.LinkedState;
import goalBasedProblems.solvers.GoalBasedSolver;
import utils.Descriptionable;
import utils.Solver;

import java.util.ArrayList;

/**
 * Created by emran on 10/29/16.
 */
public class Runner extends Thread {

    private Solver solver;
    private SolveFinishedListener listener;

    public Runner(Solver solver) {
        this.solver = solver;
    }

    public Runner(Solver solver, SolveFinishedListener listener) {
        this(solver);
        this.listener = listener;
    }

    @Override
    public void run() {
        Descriptionable goal = null;
        while (goal == null) {
            goal = solver.tick();
        }

        if (goal instanceof LinkedState && listener instanceof StateFoundListener) {
            LinkedState state = (LinkedState) goal;

            ArrayList<goalBasedProblems.models.State> path = new ArrayList<>();

            while (state != null) {
                path.add(state);
                state = state.getParent();
            }

            path = reversePath(path);

            this.listener.finished(goal);
            ((StateFoundListener) this.listener).pathFound(path);
        } else
            this.listener.finished(goal);
    }

    private static ArrayList<goalBasedProblems.models.State> reversePath(ArrayList<goalBasedProblems.models.State> path) {
        ArrayList<goalBasedProblems.models.State> reverse = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--)
            reverse.add(path.get(i));

        return reverse;
    }
}
