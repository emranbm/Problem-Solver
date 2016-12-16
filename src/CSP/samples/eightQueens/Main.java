package CSP.samples.eightQueens;

import CSP.solvers.SimulatedAnnealing;
import runners.Runner;
import runners.SolveFinishedListener;
import utils.Descriptionable;

/**
 * Created by emran on 12/16/16.
 */
public class Main {

    public static void main(String[] args) {
        SimulatedAnnealing sa = new SimulatedAnnealing(new EightQueensProblem(8),new T1(),100);
        Runner runner = new Runner(sa, new SolveFinishedListener() {
            @Override
            public void finished(Descriptionable answer) {

            }
        });
    }
}
