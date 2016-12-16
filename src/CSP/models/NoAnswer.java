package CSP.models;

/**
 * Created by emran on 12/15/16.
 */
public class NoAnswer extends Answer {
    @Override
    public String describeSelf() {
        return "Search ended up with no answer to the problem.";
    }

    @Override
    public int value() {
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
