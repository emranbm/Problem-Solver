package samples;

import models.goalBased.State;
import runners.Runner;
import samples.pathFinder.Cell;
import samples.pathFinder.PathFinderProblem;
import solvers.goalBasedSolvers.TreeBasedBFS;

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

        new Runner(new TreeBasedBFS(new PathFinderProblem(walls, 5, 5, new Cell(5, 5))), (state, path) -> {
            System.out.println("Goal: " + state.describeSelf());
            System.out.println("Path:");
            printPath(path);
        }).start();
    }


    private static void printPath(ArrayList<State> path) {
        for (State state : path)
            System.out.print(state.describeSelf() + " ");

        System.out.println();
    }
}
