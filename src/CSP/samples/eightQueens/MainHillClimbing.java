package CSP.samples.eightQueens;

import CSP.solvers.*;
import runners.Runner;

/**
 * Created by emran on 12/16/16.
 */
public class MainHillClimbing {

    public static void main(String[] args) {

        Runner runner1 = new Runner(new HillClimbingSimple(new EightQueensProblem(8)), answer -> {
            System.out.println("#Simple: " + answer.describeSelf());
        });
        Runner runner2 = new Runner(new HillClimbingRandom(new EightQueensProblem(8)), answer -> {
            System.out.println("#Random: " + answer.describeSelf());
        });
        Runner runner3 = new Runner(new HillClimbingRandomRestart(new EightQueensProblem(8),
                new EightQueensAnswer[]{
                        new EightQueensAnswer(new int[]{1, 2, 3, 4, 5, 6, 7, 8}),
                        new EightQueensAnswer(new int[]{8, 2, 5, 4, 3, 6, 7, 1}),
                        new EightQueensAnswer(new int[]{5, 2, 7, 4, 3, 6, 1, 8}),
                }),
                answer -> {
                    System.out.println("#RandomRestart: " + answer.describeSelf());
                });
        Runner runner4 = new Runner(new HillClimbingFirstChoice(new EightQueensProblem(8), 3), answer -> {
            System.out.println("#FirstChoice: " + answer.describeSelf());
        });

        runner1.start();
        runner2.start();
        runner3.start();
        runner4.start();
    }
}
