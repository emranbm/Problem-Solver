package models;

import java.util.ArrayList;

/**
 * A model representing the state in a problem. Feel free to extend this class to implement your own state.
 * <p>
 * Created by emran on 10/29/16.
 */
public abstract class State implements Cloneable {

    public abstract String describeSelf();

    @Override
    public abstract boolean equals(Object obj);
}
