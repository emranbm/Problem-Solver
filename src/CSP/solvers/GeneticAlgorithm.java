package CSP.solvers;

import CSP.models.GeneticAnswer;
import utils.Helper;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public class GeneticAlgorithm implements ConstraintSolver {

    private int popSize, totalGenerations;
    private double mutationProbability;
    private ArrayList<GeneticAnswer> generation;
    private int steps = 0;

    public GeneticAlgorithm(ArrayList<GeneticAnswer> generation, int totalGenerations, double mutationProbability) {
        this.generation = generation;
        this.popSize = generation.size();
        this.totalGenerations = totalGenerations;
        this.mutationProbability = mutationProbability;
    }

    @Override
    public GeneticAnswer tick() {

        GeneticAnswer bestTillNow = generation.get(0);
        GeneticAnswer worstTillNow = generation.get(0);

        double sum = 0;

        for (GeneticAnswer a : generation) {
            if (bestTillNow.value() < a.value())
                bestTillNow = a;

            if (worstTillNow.value() > a.value())
                worstTillNow = a;

            sum += a.value();
        }

        if (steps == totalGenerations) {
            return bestTillNow;
        }

        int parentSize = (int) Math.sqrt(2 * popSize);

        ArrayList<GeneticAnswer> newGen = new ArrayList<>();

        ArrayList<GeneticAnswer> parents = new ArrayList<>();

        while (parents.size() < parentSize) {
            GeneticAnswer best = generation.get(0);
            int bestValue = Integer.MIN_VALUE;

            for (GeneticAnswer answer : generation)
                if (answer.value() > bestValue && !parents.contains(answer)) {
                    best = answer;
                    bestValue = answer.value();
                }

            parents.add(best);
        }

        int c = 0;

        for (int i = 0; i < parentSize; i++) {
            for (int j = i + 1; j < parentSize; j++) {
                GeneticAnswer a = parents.get(i);
                GeneticAnswer b = parents.get(j);

                newGen.add(a.crossOver(b));
                newGen.add(b.crossOver(a));
            }
        }

        ArrayList<GeneticAnswer> all = Helper.mergeArray(newGen, generation);

        ArrayList<GeneticAnswer> worsts = new ArrayList<>();

        while (all.size() > popSize) {
            GeneticAnswer worst = all.get(0);
            int worstValue = Integer.MAX_VALUE;
            for (GeneticAnswer a : all)
                if (a.value() < worstValue && !worsts.contains(a)) {
                    worst = a;
                    worstValue = a.value();
                    worsts.add(a);
                }

            all.remove(worst);
        }

        generation = all;

        for (GeneticAnswer answer : generation)
            if (Math.random() < mutationProbability)
                answer.mutate();

        steps++;

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
