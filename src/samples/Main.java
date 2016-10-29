package samples;

import runners.Runner;
import solvers.GraphBasedBFS;

/**
 * Created by emran on 10/29/16.
 */
public class Main {

    public static void main(String[] args) {
        new Runner(new GraphBasedBFS(new SimpleProblem())).start();
    }
}
