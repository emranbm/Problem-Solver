package goalBasedProblems.solvers;

import goalBasedProblems.models.GoalBasedProblem;
import goalBasedProblems.models.NoState;
import goalBasedProblems.models.State;

/**
 * Created by emran on 10/29/16.
 */
public class TreeBasedDFSEvolutionary extends TreeBasedDFS {
    private GoalBasedProblem goalBasedProblem;

    public TreeBasedDFSEvolutionary(GoalBasedProblem goalBasedProblem) {
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
