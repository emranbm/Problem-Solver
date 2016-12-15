package solvers.normalSolvers;

import models.NoState;
import models.Problem;
import models.State;

/**
 * Created by emran on 10/29/16.
 */
public class TreeBasedDFSEvolutionary extends TreeBasedDFS {
    private Problem problem;

    public TreeBasedDFSEvolutionary(Problem problem) {
        super(problem, 1);
        this.problem = problem;
    }

    @Override
    public State tick() {
        State result = super.tick();

        if (result != null && result instanceof NoState) {
            maxDepth++;
            queue.add(new StateDepthBundle(problem.startState(), 0));
            return null;
        } else
            return result;
    }
}
