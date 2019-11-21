package tic.game.turn.result;

import tic.game.Manager;
import tic.io.IO;

public class Exit extends Result {
    @Override
    public void handle(Manager manager, IO io) {
        io.showOutput("Exiting the game.\n");
    }
}
