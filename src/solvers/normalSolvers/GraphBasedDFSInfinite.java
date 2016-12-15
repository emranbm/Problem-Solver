package solvers.normalSolvers;

import models.Problem;

/**
 * Created by emran on 10/29/16.
 */
public class GraphBasedDFSInfinite extends GraphBasedDFS {
    public GraphBasedDFSInfinite(Problem problem) {
        super(problem, Integer.MAX_VALUE);
    }
}
