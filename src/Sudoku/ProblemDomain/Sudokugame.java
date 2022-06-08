package Sudoku.ProblemDomain;
import Sudoku.ComputationLogic.SudokuUtilities;
import Sudoku.constants.GameState;

import java.io.Serializable;
import java.util.*;
public class Sudokugame implements Serializable {
    private final GameState gameState;
    private final int[][] gridState;

    public static final int GRID_BOUNDARY=9;

    public Sudokugame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][]  getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }
}
