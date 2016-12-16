package solvers.goalBasedSolvers;

import models.goalBased.GoalBasedProblem;

/**
 * Created by emran on 10/29/16.
 */
public class TreeBasedDFSInfinite extends TreeBasedDFS {
    public TreeBasedDFSInfinite(GoalBasedProblem goalBasedProblem) {
        super(goalBasedProblem, Integer.MAX_VALUE);
    }
}
