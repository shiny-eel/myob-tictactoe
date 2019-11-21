package tic.game;

import tic.game.board.Board;
import tic.game.turn.result.Result;
import tic.io.IO;

/**
 * Class with the responsibility of managing the game.
 * Has knowledge of the board and players (including the current player).
 * Responsible for prompting turns and handling their results.
 */
public class Manager {

    private IO _io;
    private Board _board;
    private Player _p1;
    private Player _p2;
    private Player _currentPlayer;
    private static final String WELCOME = "Welcome to Tic Tac Toe!\n" +
            "\n" +
            "Here's the current board:\n";

    public void begin(IO io) {
        _board = new Board();
        _p1 = new Player("X", 1, _board);
        _p2 = new Player("O", 2, _board);
        _currentPlayer = _p1;
        _io = io;
        io.showOutput(WELCOME);
        displayGame();
        nextTurn();
    }

    public Player nextPlayer() {
        if (_currentPlayer.equals(_p1)) {
            _currentPlayer = _p2;
            return _currentPlayer;
        } else {
            _currentPlayer = _p1;
            return _currentPlayer;
        }
    }

    public void nextTurn() {
        Result result = _currentPlayer.executeTurn(_io);
        result.handle(this, _io);
    }

    public void displayGame() {
        _board.display(_io);
    }

}
