package solvers.normalSolvers;

import models.Problem;

/**
 * Created by emran on 10/29/16.
 */
public class TreeBasedDFSInfinite extends TreeBasedDFS {
    public TreeBasedDFSInfinite(Problem problem) {
        super(problem, Integer.MAX_VALUE);
    }
}
