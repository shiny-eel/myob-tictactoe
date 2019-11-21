package tic.game.turn.result;

import tic.game.Manager;
import tic.io.IO;

public class Draw extends Result {

    @Override
    public void handle(Manager manager, IO io) {
        io.showOutput("A draw has been reached.\n"); // TODO
        manager.displayGame();
    }
}
