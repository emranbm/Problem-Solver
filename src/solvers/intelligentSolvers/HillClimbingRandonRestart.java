package solvers.intelligentSolvers;

import models.Problem;
import models.State;
import solvers.Helper;
import solvers.Solver;

/**
 * Created by emran on 12/15/16.
 */
public class HillClimbingRandonRestart implements Solver {

    private Problem problem;
    private HillClimbingSimple[] solvers;

    private State[] results;

    /**
     * @param problem      Note that the given problem <b>h</b> method, should represent a value of a state, instead of a heuristic function. <br/>
     *                     There is also no need to specify the start state, due the given randomStarts replace the problem start states.
     * @param randomStarts The random restarts when a peak achieved.
     **/
    public HillClimbingRandonRestart(Problem problem, State[] randomStarts) {
        this.problem = problem;
        this.solvers = new HillClimbingSimple[randomStarts.length];
        this.results = new State[randomStarts.length];

        for (int i = 1; i < randomStarts.length; i++) {
            solvers[i] = new HillClimbingSimple(Helper.overrideStartState(problem, randomStarts[i]));
        }
    }

    @Override
    public State tick() {

        boolean allFinished = true;

        for (int i = 0; i < results.length; i++) {
            if (results[i] == null) {
                results[i] = solvers[i].tick();
            }

            if (results[i] == null)
                allFinished = false;
        }

        if (allFinished) {
            State bestState = results[0];

            for (State s : results) {
                if (problem.h(s) > problem.h(bestState))
                    bestState = s;
            }

            return bestState;
        }

        return null;
    }

    @Override
    public int getSeenStatesCount() {
        return 0;
    }

    @Override
    public int getExpandedCount() {
        return 0;
    }

    @Override
    public int maxNodesInRAM() {
        return 0;
    }
}
