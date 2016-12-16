package CSP.models;

import java.util.ArrayList;

/**
 * Created by emran on 12/15/16.
 */
public abstract class ConstraintProblem {

    public abstract ArrayList<Answer> neighbors(Answer answer);

    public abstract Answer initialAnswer();

}
