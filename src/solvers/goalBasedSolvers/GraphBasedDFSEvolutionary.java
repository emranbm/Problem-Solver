package solvers.goalBasedSolvers;

import models.goalBased.GoalBasedProblem;
import models.goalBased.NoState;
import models.goalBased.State;

/**
 * Created by emran on 10/29/16.
 */
public class GraphBasedDFSEvolutionary extends GraphBasedDFS {
    private GoalBasedProblem goalBasedProblem;

    public GraphBasedDFSEvolutionary(GoalBasedProblem goalBasedProblem) {
        super(goalBasedProblem, 1);
        this.goalBasedProblem = goalBasedProblem;
    }

    @Override
    public State tick() {
        State result = super.tick();

        if (result != null && result instanceof NoState) {
            maxDepth++;
            queue.add(new StateDepthBundle(goalBasedProblem.startState(), 0));
            return null;
        } else
            return result;
    }
}
