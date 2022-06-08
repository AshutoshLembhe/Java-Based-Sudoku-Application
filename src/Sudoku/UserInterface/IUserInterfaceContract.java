package Sudoku.UserInterface;

import Sudoku.ProblemDomain.Sudokugame;

import java.awt.*;

public interface IUserInterfaceContract {
    interface EventListner{
        void onSudokuInput(int x,int y, int input);
        void onDialogClick();
    }
    interface View{
        void setListner(IUserInterfaceContract.EventListner listner);
        void updateSquare(int x, int y, int input);
        void updateBoard(Sudokugame game);
        void showDialog(String message);
        void showError(String message);
    }
}
