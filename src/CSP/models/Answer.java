package CSP.models;

import Descriptionable;

/**
 * Created by emran on 12/15/16.
 */
public abstract class Answer implements Descriptionable {

    public abstract int value();

    @Override
    public abstract boolean equals(Object obj);
}
