package CSP.models;

/**
 * Created by emran on 12/16/16.
 */
public abstract class GeneticAnswer extends Answer {

    public abstract void mutate();

    public abstract GeneticAnswer crossOver(GeneticAnswer geneticAnswer);

}
