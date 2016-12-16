package runners;

import goalBasedProblems.models.State;
import utils.Descriptionable;

/**
 * Created by emran on 12/16/16.
 */
public interface SolveFinishedListener {

    void finished(Descriptionable answer);
}
