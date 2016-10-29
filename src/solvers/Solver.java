package solvers;

/**
 * Created by emran on 10/29/16.
 */
public interface Solver {

    /**
     * This method gets called periodically.
     *
     * @return True if the search is completed. Otherwise false.
     */
    boolean tick();
}
