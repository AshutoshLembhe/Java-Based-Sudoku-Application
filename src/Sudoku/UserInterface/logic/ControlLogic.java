package Sudoku.UserInterface.logic;

import Sudoku.ComputationLogic.GameLogic;
import Sudoku.ProblemDomain.IStorage;
import Sudoku.ProblemDomain.Sudokugame;
import Sudoku.UserInterface.IUserInterfaceContract;
import Sudoku.constants.GameState;
import Sudoku.constants.Messages;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventListner {

    private IStorage storage;
    private IUserInterfaceContract.View view;

    public ControlLogic(IStorage storage, IUserInterfaceContract.View view) {
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onSudokuInput(int x, int y, int input) {
        try{
            Sudokugame gameData=storage.getGameData();
            int[][] newGridState= gameData.getCopyOfGridState();
            newGridState[x][y]=input;
            gameData = new Sudokugame(
                GameLogic.checkForCompletion(newGridState),newGridState);
            storage.updateGameData(gameData);
            view.updateSquare(x,y,input);
            if(gameData.getGameState()== GameState.COMPLETE){
                view.showDialog(Messages.GAME_COMPLETE);
            }
        }catch(IOException e){
            e.printStackTrace();
            view.showError(Messages.ERROR);
        }

    }

    @Override
    public void onDialogClick() {
        try{
            storage.updateGameData(GameLogic.getNewGame());
            view.updateBoard(storage.getGameData());
        }catch (IOException e){
            view.showError(Messages.ERROR);
        }

    }
}
