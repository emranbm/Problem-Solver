package runners;

import solvers.Solver;

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
        models.State goal = null;
        while (goal == null) {
            goal = solver.tick();
        }
        this.listener.found(goal);

        models.State state = goal;

        ArrayList<models.State> path = new ArrayList<>();

        while (state != null) {
            path.add(state);
            state = state.getParent();
        }

        path = reversePath(path);

        printPath(path);
    }

    private static ArrayList<models.State> reversePath(ArrayList<models.State> path) {
        ArrayList<models.State> reverse = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0; i--)
            reverse.add(path.get(i));

        return reverse;
    }

    private static void printPath(ArrayList<models.State> path) {
        for (models.State state : path)
            System.out.print(state.getId() + " ");

        System.out.println();
    }
}
