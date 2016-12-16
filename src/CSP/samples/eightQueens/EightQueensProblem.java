package CSP.samples.eightQueens;

import CSP.models.Answer;
import CSP.models.ConstraintProblem;

import java.util.ArrayList;

/**
 * Created by emran on 12/16/16.
 */
public class EightQueensProblem extends ConstraintProblem {

    private EightQueensAnswer initAnswer;
    private int size;

    public EightQueensProblem(int size) {
        int[] p = new int[size];
        this.size = size;

        for (int i = 0; i < p.length; i++)
            p[i] = i + 1;

        initAnswer = new EightQueensAnswer(p);

    }

    @Override
    public ArrayList<Answer> neighbors(Answer answer) {
        ArrayList<Answer> result = new ArrayList<>();

        int[] p = ((EightQueensAnswer) answer).getPositions();

        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++) {
                int[] a = new int[size];
                for (int k = 0; k < size; k++) {
                    if (k == i)
                        a[k] = p[j];
                    else if (k == j)
                        a[k] = p[i];
                    else
                        a[k] = p[k];
                }

                result.add(new EightQueensAnswer(a));
            }

        return result;

    }

    @Override
    public Answer initialAnswer() {
        return initAnswer;
    }
}
