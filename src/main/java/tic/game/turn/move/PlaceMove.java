package tic.game.turn.move;

import tic.game.Player;
import tic.game.board.Board;
import tic.game.board.BoardException;
import tic.game.turn.result.*;

import java.util.regex.Pattern;

public class PlaceMove extends Move {

    public PlaceMove(Player owner, Board board) {
        super(owner, board);
    }

    @Override
    public Result handle() {
        int row = Integer.parseInt(matcher.group(1)) - 1;
        int col = Integer.parseInt(matcher.group(2)) - 1;
        try {
            if (!board.isEmpty(row, col))
                return new RepeatPlayer(RepeatPlayer.Type.OccupiedTile);
            if (board.place(row, col, owner))
                return new Victory();
            if (board.isFull())
                return new Draw();
            return new NextPlayer();
        } catch (BoardException e) {
            return new RepeatPlayer(RepeatPlayer.Type.OutOfBoard);
        }
    }

    @Override
    Pattern compilePattern() {
        String p = "([1-3]),([1-3])";
        return Pattern.compile(p);
    }
}
