package samples.pathFinder;

import models.Action;
import models.LinkedState;
import models.Problem;
import models.State;

import java.util.ArrayList;

/**
 * Created by emran on 11/11/16.
 */
public class PathFinderProblem extends Problem {

    private ArrayList<Cell[]> walls;
    private int width, height;
    private Cell goal;

    public PathFinderProblem(ArrayList<Cell[]> walls, int width, int height, Cell goal) {
        this.walls = walls;
        this.width = width;
        this.height = height;
        this.goal = goal;
    }

    @Override
    public State startState() {
        return new Cell(1, 1);
    }

    @Override
    public ArrayList<Action> availableActions(State state) {

        ArrayList<Action> actions = new ArrayList<>();

        Cell cell = (Cell) state;

        //Left
        if (cell.getX() > 1)
            actions.add(new CellAction(-1, 0));

        //Right
        if (cell.getX() < width)
            actions.add(new CellAction(1, 0));

        //Up
        if (cell.getY() > 1)
            actions.add(new CellAction(0, -1));

        //Down
        if (cell.getY() < height)
            actions.add(new CellAction(0, 1));

        return actions;
    }

    @Override
    public State actionResult(State state, Action action) {

        int i = ((CellAction) action).getDx();
        int j = ((CellAction) action).getDy();

        Cell cell = (Cell) state;

        return new Cell(cell.getX() + i, cell.getY() + j);
    }

    @Override
    public boolean isGoal(State state) {
        return goal.equals(state);
    }
}
