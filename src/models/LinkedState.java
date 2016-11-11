package models;

/**
 * Created by emran on 11/11/16.
 */
public abstract class LinkedState extends State {
    private LinkedState parent;

    public LinkedState getParent() {
        return parent;
    }

    public void setParent(LinkedState parent) {
        this.parent = parent;
    }
}
