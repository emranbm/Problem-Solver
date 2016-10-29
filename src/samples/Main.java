package samples;

import runners.Runner;
import solvers.*;

/**
 * Created by emran on 10/29/16.
 */
public class Main {

    public static void main(String[] args) {
        new Runner(new TreeBasedDFSEvolutionary(new SimpleProblem())).start();
    }
}
