package solvers.constraintSolvers;

import models.constraintSatisfaction.Answer;

/**
 * Created by emran on 10/29/16.
 */
public interface ConstraintSolver {

    /**
     * This method gets called periodically.
     *
     * @return The goal state if found. Returns null if not found the goal yet.
     */
    Answer tick();

    int getSeenStatesCount();
    int getExpandedCount();
    int maxNodesInRAM();
}
