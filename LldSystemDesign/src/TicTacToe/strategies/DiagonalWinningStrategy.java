package TicTacToe.strategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinner(Move move, Board board) {
        return false;
    }
    @Override
    public void handleUndo(Move move, Board board){
        return;
    }
}
