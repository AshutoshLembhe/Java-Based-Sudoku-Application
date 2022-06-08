package Sudoku.ProblemDomain;

import java.io.IOException;

public interface IStorage {
    void updateGameData(Sudokugame game) throws IOException;
    Sudokugame getGameData() throws IOException;
}
