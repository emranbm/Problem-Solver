package CSP.samples.eightQueens;

import CSP.solvers.SimulatedAnnealing;

/**
 * Created by emran on 12/16/16.
 */
public class T1 implements SimulatedAnnealing.TFunction {
    @Override
    public double p(int step) {
        return 1 / step;
    }
}
