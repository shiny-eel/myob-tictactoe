package tic.game.turn.move;

import tic.game.Player;
import tic.game.board.Board;
import tic.game.turn.result.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to represent any possible 'move' in the TicTacToe game.
 * Has responsibility of matching a String, and returning a Result once executed.
 */
public abstract class Move {
    private Pattern _pattern;
    Matcher matcher;
    Player owner;
    protected Board board;

    public Move(Player owner, Board board) {
        _pattern = compilePattern();
        this.owner = owner;
        this.board = board;
    }

    public boolean matches(String line) {
        matcher = _pattern.matcher(line);
        return matcher.find();
    }

    public abstract Result handle();

    abstract Pattern compilePattern();

}
