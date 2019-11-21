package tic.game.turn.result;

import tic.game.Manager;
import tic.io.IO;

public class RepeatPlayer extends Result {
    public enum Type {
        OccupiedTile(
                "Oh no, a piece is already at this place! Try again...\n"),
        OutOfBoard(
                "Oh no, that coordinate doesn't fit onto the board! Ty again...\n"),
        UnrecognisedInput(
                "Sorry! Your input was unrecognisable. Try again...\n");
        String message;
        Type(String msg) {
            message = msg;
        }

    }
    private Type _type;
    public RepeatPlayer(Type type) {
        _type = type;
    }

    @Override
    public void handle(Manager manager, IO io) {
        io.showOutput(_type.message);
        manager.nextTurn();
    }
}
