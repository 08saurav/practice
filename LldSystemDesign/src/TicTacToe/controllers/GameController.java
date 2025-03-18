package TicTacToe.controllers;

import TicTacToe.models.Game;
import TicTacToe.models.GameState;
import TicTacToe.models.Player;
import TicTacToe.strategies.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> strategies) {
//        1. No. of players = board size -1
//        2. Every Player should have a different Symbol
//        3. There should be only 1 bot in the game
//        return new Game(dimension,players,strategies);
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(strategies)
                .build();
    }
    public void displayTheBoard(Game game) {
        game.displayBoard();
    }
    public GameState checkGameState(Game game) {
        return game.getGameState();
    }

    public void undo(Game game) {
        game.handleUndo();
    }
    public Player getWinner(Game game) {
        return game.getWinner();
    }
    public void makeMove(Game game) {
        game.makeMove();
    }
}
// Client -> GameContoller -> Service
// 1. Start Game
// 2. while game state is IN_PROGRESS
    // 2.1. Initialize the board and display the board
    // 2.2. Make the move
    // 2.3. check the winner
