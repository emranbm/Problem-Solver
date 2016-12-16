package goalBasedProblems.models;

/**
 * A class representing situations where no state is finished in a search. (Note that returning null in Runners shows that no state finished <b>yet</b>!)
 * <br/>
 * Created by emran on 11/11/16.
 */
public class NoState extends State {
    @Override
    public String describeSelf() {
        return "Search completed and nothing finished!";
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
