package goalBasedProblems.samples.pathFinder;

import goalBasedProblems.models.Action;
import goalBasedProblems.models.GoalBasedProblem;
import goalBasedProblems.models.State;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by emran on 11/11/16.
 */
public class PathFinderProblem extends GoalBasedProblem {

    private HashMap<Cell, Cell> walls;
    private int width, height;
    private Cell goal;

    public PathFinderProblem(HashMap<Cell, Cell> walls, int width, int height, Cell goal) {
        this.walls = walls;
        this.width = width;
        this.height = height;
        this.goal = goal;
    }

    @Override
    public State startState() {
        return new Cell(1, 1);
    }

    private boolean isWall(Cell cell1, Cell cell2) {
        try {
            if (walls.get(cell1).equals(cell2))
                return true;
        } catch (NullPointerException e) {
        }

        try {
            if (walls.get(cell2).equals(cell1))
                return true;
        } catch (NullPointerException e) {
        }

        return false;
    }

    @Override
    public ArrayList<Action> availableActions(State state) {

        ArrayList<Action> actions = new ArrayList<>();

        Cell cell = (Cell) state;

        Cell newCell;

        //Left
        newCell = (Cell) actionResult(state, new CellAction(-1, 0));
        if (cell.getX() > 1 && !isWall(newCell, (Cell) state))
            actions.add(new CellAction(-1, 0));

        //Right
        newCell = (Cell) actionResult(state, new CellAction(1, 0));
        if (cell.getX() < width && !isWall(newCell, (Cell) state))
            actions.add(new CellAction(1, 0));

        //Up
        newCell = (Cell) actionResult(state, new CellAction(0, -1));
        if (cell.getY() > 1 && !isWall(newCell, (Cell) state))
            actions.add(new CellAction(0, -1));

        //Down
        newCell = (Cell) actionResult(state, new CellAction(0, 1));
        if (cell.getY() < height && !isWall(newCell, (Cell) state))
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
