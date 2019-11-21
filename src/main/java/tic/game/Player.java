package tic.game;

import tic.game.board.Board;
import tic.game.turn.move.Move;
import tic.game.turn.move.PlaceMove;
import tic.game.turn.move.QuitMove;
import tic.game.turn.result.RepeatPlayer;
import tic.game.turn.result.Result;
import tic.io.IO;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class Player {

    private String _symbol;
    private int _number;
    private List<Move> _moves;
    private Board _board;
    private static final String PLACE_PROMPT =
            "Player {0} enter a coord x,y to place your {1} or enter {2} to give up:";

    public Player(String symbol, int number,  Board board) {
        _number = number;
        _symbol = symbol;
        _board = board;
        _moves = new LinkedList<>();
        _moves.add(new PlaceMove(this, board));
        _moves.add(new QuitMove(this, board));
    }

    Result executeTurn(IO io) {
        Object[] params = new Object[]{""+ _number, _symbol, "\'q\'"};
        String msg = MessageFormat.format(PLACE_PROMPT, params);
        io.showOutput(msg);
        String in = io.getInput();
//        io.showOutput("\n");
        for (Move move : _moves) {
            if (move.matches(in)) {
                return move.handle();
            }
        }
        // No matching move
        return new RepeatPlayer(RepeatPlayer.Type.UnrecognisedInput);
    }

    public String getSymbol() {
        return _symbol;
    }
}
