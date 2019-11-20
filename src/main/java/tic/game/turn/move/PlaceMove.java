package tic.game.turn.move;

import tic.game.Manager;
import tic.game.board.Board;

import java.util.regex.Pattern;

public class PlaceMove extends Move {
    public PlaceMove(Manager manager) {
        super(manager);
    }

    @Override
    void handle(Board board) {

    }

    @Override
    Pattern compilePattern() {
        String p = "([1-3]),([1-3])";
        return Pattern.compile(p);
    }
}
