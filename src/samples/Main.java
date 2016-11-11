package samples;

import models.State;
import runners.Runner;
import runners.StateFoundListener;
import samples.eightQueens.CheckerState;
import samples.eightQueens.EightQueensProblem;
import samples.pathFinder.Cell;
import samples.pathFinder.PathFinderProblem;
import solvers.*;

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
            public void found(State state, ArrayList<State> path) {
                System.out.println("Goal: " + state.describeSelf());
                System.out.println("Path:");
                printPath(path);
            }
        }).start();
    }


    private static void printPath(ArrayList<models.State> path) {
        for (models.State state : path)
            System.out.print(state.describeSelf() + " ");

        System.out.println();
    }
}
