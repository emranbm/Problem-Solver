package runners;

import models.State;
import solvers.Solver;

/**
 * Created by emran on 10/29/16.
 */
public class Runner extends Thread {

    private Solver solver;

    public Runner(Solver solver) {
        this.solver = solver;
    }

    @Override
    public void run() {
        models.State goal = null;
        while (goal == null) {
            goal = solver.tick();
        }

        //TODO print nice result :)
        System.out.println(goal.getId());
    }
}
