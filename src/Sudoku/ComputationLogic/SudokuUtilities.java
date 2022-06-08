package Sudoku.ComputationLogic;
import Sudoku.ProblemDomain.Sudokugame;
public class SudokuUtilities {
    public static void copySudokuArrayValues(int[][] oldArray, int[][] newArray) {
        for (int xIndex = 0; xIndex < Sudokugame.GRID_BOUNDARY; xIndex++){
            for (int yIndex = 0; yIndex < Sudokugame.GRID_BOUNDARY; yIndex++ ){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }
    }

    /**
     * Creates and returns a new Array with the same values as the inputted Array.
     *
     * @param oldArray
     */
    public static int[][] copyToNewArray(int[][] oldArray) {
        int[][] newArray = new int[Sudokugame.GRID_BOUNDARY][Sudokugame.GRID_BOUNDARY];
        for (int xIndex = 0; xIndex < Sudokugame.GRID_BOUNDARY; xIndex++){
            for (int yIndex = 0; yIndex < Sudokugame.GRID_BOUNDARY; yIndex++ ){
                newArray[xIndex][yIndex] = oldArray[xIndex][yIndex];
            }
        }

        return newArray;
    }
}
