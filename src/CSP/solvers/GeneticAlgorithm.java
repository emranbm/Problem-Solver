package CSP.solvers;

import CSP.models.Answer;
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

        if (steps == totalGenerations) {
            GeneticAnswer best = generation.get(0);

            for (GeneticAnswer a : generation)
                if (best.value() < a.value())
                    best = a;

            return best;
        }

        int parentSize = (int) Math.sqrt(2 * popSize);

        ArrayList<GeneticAnswer> newGen = new ArrayList<>();

        ArrayList<GeneticAnswer> parents = new ArrayList<>();

        while (parents.size() < parentSize) {
            GeneticAnswer best = generation.get(0);

            for (GeneticAnswer answer : generation)
                if (answer.value() > best.value() && !parents.contains(answer))
                    best = answer;

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

        while (all.size() > popSize) {
            GeneticAnswer worst = all.get(0);
            for (GeneticAnswer a : all)
                if (a.value() < worst.value())
                    worst = a;

            all.remove(worst);
        }

        generation = all;

        for (GeneticAnswer answer : generation)
            if (Math.random() < mutationProbability)
                answer.mutate();

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

    public static abstract class GeneticAnswer extends Answer {

        public abstract void mutate();

        public abstract GeneticAnswer crossOver(GeneticAnswer geneticAnswer);

    }
}
