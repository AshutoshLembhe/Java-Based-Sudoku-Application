package Sudoku.buildlogic;

import Sudoku.ComputationLogic.GameLogic;
import Sudoku.ProblemDomain.IStorage;
import Sudoku.ProblemDomain.Sudokugame;
import Sudoku.UserInterface.IUserInterfaceContract;
import Sudoku.UserInterface.logic.ControlLogic;
import Sudoku.persistence.LocalStorageImpl;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        Sudokugame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            //will throw if no game data is found in local storage

            initialState = storage.getGameData();
        } catch (IOException e) {

            initialState = GameLogic.getNewGame();
            //this method below will also throw an IOException
            //if we cannot update the game data. At this point
            //the application is considered unrecoverable
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListner uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListner(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
