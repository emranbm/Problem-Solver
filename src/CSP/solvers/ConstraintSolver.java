package CSP.solvers;

import CSP.models.Answer;
import utils.Solver;

/**
 * Created by emran on 10/29/16.
 */
public interface ConstraintSolver extends Solver {

    /**
     * This method gets called periodically.
     *
     * @return The goal state if finished. Returns null if not finished the goal yet.
     */
    Answer tick();
}
