package CSP.solvers;

import CSP.models.Answer;
import CSP.models.ConstraintProblem;
import utils.Helper;

/**
 * Created by emran on 12/15/16.
 */
public class HillClimbingRandomRestart implements ConstraintSolver {

    private HillClimbingSimple[] solvers;

    private Answer[] results;

    /**
     * @param problem      Note that the given GoalBasedProblem <b>h</b> method, should represent a value of a state, instead of a heuristic function. <br/>
     *                     There is also no need to specify the start state, due the given randomStarts replace the GoalBasedProblem start states.
     * @param randomStarts The random restarts when a peak achieved.
     **/
    public HillClimbingRandomRestart(ConstraintProblem problem, Answer[] randomStarts) {
        this.solvers = new HillClimbingSimple[randomStarts.length];
        this.results = new Answer[randomStarts.length];

        for (int i = 0; i < randomStarts.length; i++) {
            solvers[i] = new HillClimbingSimple(Helper.overrideInitialAnswer(problem, randomStarts[i]));
        }
    }

    @Override
    public Answer tick() {

        boolean allFinished = true;

        for (int i = 0; i < results.length; i++) {
            if (results[i] == null) {
                results[i] = solvers[i].tick();
            }

            if (results[i] == null)
                allFinished = false;
        }

        if (allFinished) {
            Answer bestState = results[0];

            for (Answer s : results) {
                if (s.value() > bestState.value())
                    bestState = s;
            }

            return bestState;
        }

        return null;
    }

    @Override
    public int getSeenStatesCount() {
        int a = 0;
        for (ConstraintSolver s : solvers)
            a += s.getSeenStatesCount();
        return a;
    }

    @Override
    public int getExpandedCount() {
        int a = 0;
        for (ConstraintSolver s : solvers)
            a += s.getExpandedCount();
        return a;
    }

    @Override
    public int maxNodesInRAM() {
        int a = 0;
        for (ConstraintSolver s : solvers)
            a += s.maxNodesInRAM();
        return a;
    }
}
