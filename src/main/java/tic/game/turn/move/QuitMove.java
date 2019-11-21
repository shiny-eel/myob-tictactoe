package tic.game.turn.move;

import tic.game.Player;
import tic.game.board.Board;
import tic.game.turn.result.Exit;
import tic.game.turn.result.Result;

import java.util.regex.Pattern;

public class QuitMove extends Move {

    public QuitMove(Player owner, Board board) {
        super(owner, board);
    }

    @Override
    public Result handle() {
        return new Exit();
    }

    @Override
    Pattern compilePattern() {
        // Case insensitive
        String p = "[Qq]";
        return Pattern.compile(p);
    }
}
