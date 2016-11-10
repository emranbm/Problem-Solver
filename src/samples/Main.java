package samples;

import models.State;
import runners.Runner;
import runners.StateFoundListener;
import samples.eightQueens.CheckerState;
import samples.eightQueens.EightQueensProblem;
import solvers.*;

/**
 * Created by emran on 10/29/16.
 */
public class Main {

    public static void main(String[] args) {
        new Runner(new TreeBasedBFS(new EightQueensProblem()), new StateFoundListener() {
            @Override
            public void found(State state) {
                for (int i : ((CheckerState) state).getPermutation())
                    System.out.print(i + " ");
                System.out.println();
            }
        }).start();
    }
}
