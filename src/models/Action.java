package models;

/**
 * Created by emran on 10/29/16.
 */
public abstract class Action {

    public abstract State getResult();

    public abstract int getCost();
}
