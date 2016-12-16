import goalBasedProblems.models.State;
import runners.Runner;
import goalBasedProblems.samples.pathFinder.Cell;
import goalBasedProblems.samples.pathFinder.PathFinderProblem;
import goalBasedProblems.solvers.TreeBasedBFS;
import runners.StateFoundListener;
import utils.Descriptionable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by emran on 10/29/16.
 */
public class Main {

    public static void main(String[] args) {

        HashMap<Cell, Cell> walls = new HashMap<>();
        walls.put(new Cell(3, 2), new Cell(4, 2));
        walls.put(new Cell(3, 3), new Cell(4, 3));
        walls.put(new Cell(2, 3), new Cell(2, 4));
        walls.put(new Cell(3, 3), new Cell(3, 4));

        new Runner(new TreeBasedBFS(new PathFinderProblem(walls, 5, 5, new Cell(5, 5))), new StateFoundListener() {

            @Override
            public void pathFound(ArrayList<State> path) {
                System.out.println("Path:");
                printPath(path);
            }

            @Override
            public void finished(Descriptionable answer) {
                System.out.println("Goal: " + answer.describeSelf());
            }
        }).start();
    }


    private static void printPath(ArrayList<State> path) {
        for (State state : path)
            System.out.print(state.describeSelf() + " ");

        System.out.println();
    }
}
