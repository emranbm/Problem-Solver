package CSP.samples.eightQueens;

import CSP.models.Answer;

/**
 * Created by emran on 12/16/16.
 */
public class EightQueensAnswer extends Answer {

    private int[] positions;

    public EightQueensAnswer(int[] positions) {
        this.positions = positions;
    }

    @Override
    public String describeSelf() {
        String self = "[";
        for (int i : positions)
            self += i + ", ";

        self = self.substring(0,self.length() - 2) + "]";

        return self;
    }

    public int[] getPositions() {
        return positions;
    }

    @Override
    public int value() {
        int faults = 0;

        for (int i = 0; i < positions.length; i++)
            for (int j = i + 1; j < positions.length; j++) {
                if (positions[i] == positions[j])
                    faults++;

                if (j - i == Math.abs(positions[i] - positions[j]))
                    faults++;
            }
        return -faults;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EightQueensAnswer))
            return false;

        EightQueensAnswer answer = ((EightQueensAnswer) obj);

        if (answer.positions.length != this.positions.length)
            return false;

        for (int i = 0; i < this.positions.length; i++)
            if (this.positions[i] != answer.positions[i])
                return false;

        return true;
    }
}
