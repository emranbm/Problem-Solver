package CSP.samples.equationSolving;

import CSP.models.GeneticAnswer;

/**
 * Representing an answer to the equation: Sin(x) = x^2 - x
 * Created by emran on 12/16/16.
 */
public class X extends GeneticAnswer {

    private double x;

    public X(double x) {
        this.x = x;
    }

    @Override
    public String describeSelf() {
        return "" + x;
    }

    @Override
    public void mutate() {
        x = 1/Math.exp(Math.pow(x, 2) / 0.02);
    }

    @Override
    public GeneticAnswer crossOver(GeneticAnswer geneticAnswer) {
        return new X((((X) geneticAnswer).x + this.x) / 2);
    }

    @Override
    public int value() {
        return (int) (1/Math.abs(Math.pow(x, 2) - x - Math.sin(x)));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof X && ((X) obj).x == this.x;
    }
}
