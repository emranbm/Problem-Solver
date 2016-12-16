package CSP.samples.equationSolving;

import CSP.models.GeneticAnswer;
import CSP.solvers.GeneticAlgorithm;
import runners.Runner;

import java.util.ArrayList;

/**
 * Created by emran on 12/16/16.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<GeneticAnswer> firstGeneration = new ArrayList<>();

        for (int i = 0; i < 20; i++)
            firstGeneration.add(new X(0.2 + i * 0.1));

        Runner runner = new Runner(new GeneticAlgorithm(firstGeneration, 1, 0.5), answer -> {
            System.out.println(answer.describeSelf());
        });

        runner.start();
    }
}
