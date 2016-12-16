package goalBasedProblems.solvers;

import goalBasedProblems.models.State;
import utils.Solver;

/**
 * Created by emran on 10/29/16.
 */
public interface GoalBasedSolver extends Solver {

    /**
     * This method gets called periodically.
     *
     * @return The goal state if finished. Returns null if not finished the goal yet.
     */
    State tick();
}
