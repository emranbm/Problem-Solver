package CSP.samples.eightQueens;

import CSP.solvers.SimulatedAnnealing;
import runners.Runner;
import runners.SolveFinishedListener;
import utils.Descriptionable;

/**
 * Created by emran on 12/16/16.
 */
public class MainSA {

    public static void main(String[] args) {

        Runner runner1 = new Runner(new SimulatedAnnealing(new EightQueensProblem(8), new T1(), 100)
                , answer -> {
            System.out.println("#1: " + answer.describeSelf());
        });
        Runner runner2 = new Runner(new SimulatedAnnealing(new EightQueensProblem(8), new T2(), 100)
                , answer -> {
            System.out.println("#2: " + answer.describeSelf());
        });
        Runner runner3 = new Runner(new SimulatedAnnealing(new EightQueensProblem(8), new T3(), 100)
                , answer -> {
            System.out.println("#3: " + answer.describeSelf());
        });

        runner1.start();
        runner2.start();
        runner3.start();
    }
}
