package tic.game.turn.move;

import tic.game.Manager;
import tic.game.board.Board;

import java.util.regex.Pattern;

public class QuitMove extends Move {

    public QuitMove(Manager manager) {
        super(manager);
    }

    @Override
    void handle(Board board) {

    }

    @Override
    Pattern compilePattern() {
        return null;
    }
}
