package solvers.goalBasedSolvers;

import models.goalBased.GoalBasedProblem;

/**
 * Created by emran on 10/29/16.
 */
public class GraphBasedDFSInfinite extends GraphBasedDFS {
    public GraphBasedDFSInfinite(GoalBasedProblem goalBasedProblem) {
        super(goalBasedProblem, Integer.MAX_VALUE);
    }
}
