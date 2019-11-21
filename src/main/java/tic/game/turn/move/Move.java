package tic.game.turn.move;

import tic.game.Player;
import tic.game.board.Board;
import tic.game.turn.result.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Move {
    private Pattern pattern;
    Matcher matcher;
    Player owner;
    protected Board board;


    public Move(Player owner, Board board) {
        pattern = compilePattern();
        this.owner = owner;
        this.board = board;
    }

    public boolean matches(String line) {
        matcher = pattern.matcher(line);
        return matcher.find();
    }

    public abstract Result handle();

    abstract Pattern compilePattern();

}
