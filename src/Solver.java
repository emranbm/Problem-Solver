import goalBasedProblems.models.State;

/**
 * Created by emran on 10/29/16.
 */
public interface Solver {

    /**
     * This method gets called periodically.
     *
     * @return The goal state if found. Returns null if not found the goal yet.
     */
    State tick();

    int getSeenStatesCount();
    int getExpandedCount();
    int maxNodesInRAM();
}
