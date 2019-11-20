package tic.game.turn.move;

import tic.game.Manager;
import tic.game.board.Board;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Move {
    protected Pattern _pattern;
    protected Matcher _matcher;
    protected Manager _manager;

    public Move(Manager manager){
        _pattern = compilePattern();
        _manager = manager;
    }

    boolean matches(String line) {
        _matcher = _pattern.matcher(line);
        return _matcher.find();
    }

    abstract void handle(Board board);

    abstract Pattern compilePattern();

}
