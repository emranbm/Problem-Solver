package utils;

/**
 * Created by emran on 12/16/16.
 */
public interface Solver {


    Descriptionable tick();

    int getSeenStatesCount();
    int getExpandedCount();
    int maxNodesInRAM();
}
